#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "unistd.h"
#include "sys/wait.h"
#include "ctype.h"

#define HISTORY_SIZE 20
#define HISTORY_FILE ".hist_list"

#define ALIAS_SIZE 10
#define ALIAS_LENGTH 50
#define ALIAS_FILE ".alias_list"

typedef struct {
    int number;
    char *command;
} HistoryEntry;

HistoryEntry history[HISTORY_SIZE];
int historyCount = 0;

// Declare 2D array and amount of aliases globally
char aliases[ALIAS_SIZE][ALIAS_LENGTH];
int aliasCount = 0;

void display_prompt();
char *getUserInput();
char **parseInput(char *userInput);
void pink();
void addToHistory(char *userInput);
void printHistory();
char *getCommandFromHistory(int commandNumber);
void clearHistory();
void loadHistoryFromFile();
void saveHistoryToFile();
void addAlias(char *alias, char *command);
void removeAlias(char *alias);
char *getAliasCommand(char *alias);
void printAliases();
void loadAlias();
void saveAlias();

int main() {

    // Find the user home directory from the environment
    char *homeDir = getenv("HOME");

    if (homeDir != NULL) {
        if (chdir(homeDir) != 0) {
            perror("Failed to change to HOME directory");
        }
    }

    // Save the current path
    char *originalPath = getenv("PATH");
    if (originalPath != NULL) {
        // copy of the originalPath
        originalPath = strdup(originalPath);
    } else {
        fprintf(stderr, "Failed to get PATH\n");
    }


    // Load history
    loadHistoryFromFile();
    loadAlias();

    // Shell greeting
    display_prompt();

    while (1) {

        // Display prompt for user input
        pink();
        printf("\n$~ ");

        // Read user input, including error checking
        char *userInput = getUserInput();

        // Catching no input
        if (strcmp(userInput, "") == 0) {
            free(userInput);
            continue;
        }

        // Exit by typing "exit"
        if (strcmp(userInput, "exit") == 0) {
            printf("\nexiting shell...\n");
            free(userInput);
            break;
        }

        // Add command to history before parsing and executing
        addToHistory(userInput);

        // Parse user input
        char **tokens = parseInput(userInput);

        // If input is 'clear history' then clear
        if (strcmp(tokens[0], "clear") == 0 && tokens[1] != NULL && strcmp(tokens[1], "history") == 0) {
            clearHistory();
            free(tokens);
            continue;
        }

        // If input is aliases, print aliases
        if (strcmp(tokens[0], "aliases") == 0) {
            printAliases();
            free(tokens);
            continue;
        }

        // If command is alias + command, save as alias
        if (strcmp(tokens[0], "alias") == 0 && tokens[1] != NULL && tokens[2] != NULL) {
            addAlias(tokens[1], tokens[2]);
            free(userInput);
            free(tokens);
            continue;
        }

        // If command is unalias, remove alias
        if (strcmp(tokens[0], "unalias") == 0 && tokens[1] != NULL) {
            removeAlias(tokens[1]);
            free(tokens);
            continue;
        }

        // Check if command is an alias
        char *aliasCommand = getAliasCommand(tokens[0]);
        if (aliasCommand != NULL) {

            // Replace token with alias command
            free(tokens[0]);
            tokens[0] = strdup(aliasCommand);
        }

        if (tokens[0][0] == '!') {
            int historyIndex;
            if (tokens[0][1] == '!') {
                // !! means the most recent command
                historyIndex = historyCount - 1;
            } else {
                // Extract the history number from the token
                historyIndex = atoi(tokens[0] + 1);
                if (historyIndex < 0) {
                    //handle negative history index
                    historyIndex = historyCount + historyIndex;
                } else {
                    historyIndex--;
                }
            }

            // Check if there are extra parameters
            if (tokens[1] != NULL) {
                printf("Error: Extra parameters not allowed with history invocation\n");
                free(userInput);
                free(tokens);
                continue;
            }

            if (historyIndex >= 0 && historyIndex < historyCount) {
                char *commandFromHistory = getCommandFromHistory(historyIndex);
                if (commandFromHistory != NULL) {
                    // Replace current command with the one from history

                    free(userInput);
                    userInput = strdup(commandFromHistory);
                    // Re-parse updated user input
                    tokens = parseInput(userInput);

                } else {
                    printf("Error: Invalid history invocation\n");
                    free(userInput);
                    free(tokens);
                    continue;
                }
            } else {
                printf("Error: Invalid history index\n");
                free(userInput);
                free(tokens);
                continue;
            }
        }

        // Check if command is cd
        if (strcmp(tokens[0], "cd") == 0) {

            // Change directory
            if (chdir(tokens[1]) != 0) {
                perror("cd error");
                continue;
            }

            if (chdir(tokens[2]) == 0) {
                fprintf(stderr, "\ncd error: too many arguments!");
                return 0;
            }

            continue;
        }

        int isBuiltIn = 0; // Flag to indicate if command is built-in

        // Assuming tokens[0] contains the command name
        if (strcmp(tokens[0], "getpath") == 0) {
            // Error handling for unexpected parameters with getpath
            if (tokens[1] != NULL) {
                printf("Error: getpath does not take any parameters.\n");
            } else {
                char *currentPath = getenv("PATH");
                if (currentPath != NULL) {
                    printf("Current PATH: %s\n", currentPath);
                } else {
                    printf("Failed to retrieve PATH\n");
                }
            }
            isBuiltIn = 1; // Mark as built-in command
        } else if (strcmp(tokens[0], "setpath") == 0) {
            // Error handling for setpath with no parameters or too many parameters
            if (tokens[1] == NULL || tokens[2] != NULL) {
                printf("Error: setpath requires only one parameter.\n");
            } else {
                // Set the PATH to the new value provided in tokens[1]
                if (setenv("PATH", tokens[1], 1) != 0) {
                    perror("Failed to set PATH");
                }
            }
            isBuiltIn = 1; // Mark as built-in command
        } else if (strcmp(tokens[0], "history") == 0) {
            //check for unwanted parameters
            if (tokens[1] != NULL) {
                printf("Error: 'history' command does not take any parameters.\n");
            } else {
                printHistory();
            }
            isBuiltIn = 1;
        }

        if (isBuiltIn) {
            free(tokens);
            continue;
        }


        // Fork for commands
        pid_t pid = fork();

        // Error in creating child process
        if (pid < 0) {
            perror("Error creating child process");
            exit(EXIT_FAILURE);
        }

        // Successfully created child process
        if (pid == 0) {

            if (execvp(tokens[0], tokens) == -1) {
                perror(tokens[0]);
                exit(EXIT_FAILURE);
            }
        }

        if (pid > 0) {
            wait(NULL);
        }
        free(tokens);
    }

    // Save history
    saveHistoryToFile();
    saveAlias();

    // Restore original path
    if (originalPath != NULL) {
        if (setenv("PATH", originalPath, 1) != 0) {
            perror("Failed to restore original PATH");
        } else {
            printf("Original PATH restored: %s\n", originalPath);
        }
        free(originalPath); // Free the duplicated string
    }


    return 0;
}

// Shortcuts for changing text colour
void pink() {
    printf("\033[0;35m");
}

void cyan() {
    printf("\033[0;36m");
}

void yellow() {
    printf("\033[0;33m");
}

void display_prompt() {

    yellow();
    printf("- - - - - - - - - - simpleShell - - - - - - - - - -\n");
    cyan();
    printf("        ___  __   __  __   __  __   __  ___     \n"
           "       |   ||  |_|  ||  |_|  ||  |_|  ||   |    \n"
           "       |   ||       ||       || "
           "      ||   |    \n"
           "       |   ||       ||       ||       ||   |    \n"
           "    ___|   ||       ||       ||       ||   |___ \n"
           "   |       || ||_|| || ||_|| || ||_|| ||       |\n"
           "   |_______||_|   |_||_|   |_||_|   |_||_______|\n");
    yellow();
    printf("- - - - - - - - - - - CS210 - - - - - - - - - - - - \n\n\n");
    pink();
}

// Display prompt, get user input, check for errors and character limit
char *getUserInput() {

    char *input = malloc(512);

    // Whilst we have input, take the input and remove the new line
    if (input) {
        printf("\033[0;0m");

        // Exit using Ctrl+D
        if (fgets(input, 512, stdin) == NULL) {
            printf("\nexiting shell...\n");
            exit(EXIT_SUCCESS);
        }

        // Remove new line from input
        input[strcspn(input, "\n")] = 0;
    }

    return input;
}

char **parseInput(char *userInput) {

    // Declare limits and variables for delimiting and parsing
    int tokenLimit = 50;
    int count = 0;
    char **tokens = malloc(tokenLimit * sizeof(char *));
    char *token = strtok(userInput, " \t|<>&;");

    // If no tokens, reprint display
    if (!tokens) {
        return 0;
    }

    while (token != NULL) {

        // Handle token limit of 50
        if (count >= tokenLimit) {
            fprintf(stderr, "reached token limit! (%d), please try again\n", tokenLimit);
            return 0;
        }

        // Iterate through tokens
        tokens[count] = token;
        count++;
        token = strtok(NULL, " \t|<>&;");

    }
    tokens[count] = NULL;
    return tokens;
}

void addToHistory(char *userInput) {

    // Check if the command starts with '!'
    if (userInput[0] == '!') {
        return;  // Skip adding commands starting with '!' to history
    }

    // Check if the command is 'history' without parameters
    if (strcmp(userInput, "history") == 0 || strncmp(userInput, "history ", 8) != 0) {
        if (historyCount < HISTORY_SIZE) {
            history[historyCount].number = historyCount + 1;
            history[historyCount].command = strdup(userInput);
            historyCount++;
        } else {
            // Shift all entries down, discarding the oldest entry
            for (int i = 1; i < HISTORY_SIZE; i++) {
                free(history[i - 1].command);
                history[i - 1].number = i;
                history[i - 1].command = strdup(history[i].command);
            }

            // Add the most recent entry at the end
            free(history[HISTORY_SIZE - 1].command);
            history[HISTORY_SIZE - 1].number = historyCount;
            history[HISTORY_SIZE - 1].command = strdup(userInput);
        }
    }
}

void printHistory() {
    for (int i = 0; i < historyCount; i++) {
        if (history[i].number > 0) {
            printf("%d %s\n", history[i].number, history[i].command);
        }
    }
}

char *getCommandFromHistory(int commandNumber) {
    if (commandNumber >= 0 && commandNumber < historyCount) {
        return strdup(history[commandNumber % HISTORY_SIZE].command);
    } else if (commandNumber < 0 && -commandNumber <= historyCount) {
        // Handle negative indices
        return strdup(history[(historyCount + commandNumber) % HISTORY_SIZE].command);
    }
    return NULL;  // Invalid history number
}

void clearHistory() {
    for (int i = 0; i < historyCount; i++) {
        free(history[i].command);
        history[i].number = 0; // Reset numbers to 0
        history[i].command = NULL; // Set commands to NULL
    }
    historyCount = 0; // Reset history count
}

void loadHistoryFromFile() {
    char historyFilePath[1024];
    snprintf(historyFilePath, sizeof(historyFilePath), "%s/%s", getenv("HOME"), HISTORY_FILE);
    FILE *file = fopen(historyFilePath, "r");
    if (file == NULL) {
        return;
    }

    char line[512];
    while (fgets(line, sizeof(line), file) != NULL) {
        line[strcspn(line, "\n")] = 0;
        addToHistory(line + 2);
    }

    fclose(file);
}

void saveHistoryToFile() {
    char historyFilePath[1024];
    snprintf(historyFilePath, sizeof(historyFilePath), "%s/%s", getenv("HOME"), HISTORY_FILE);
    FILE *file = fopen(historyFilePath, "w");
    if (file == NULL) {
        perror("Failed to open history file for writing");
        return;
    }

    for (int i = 0; i < historyCount; i++) {
        fprintf(file, "%d %s\n", i + 1, history[i].command);
    }

    fclose(file);
}

void addAlias(char *alias, char *command) {
    if (aliasCount < ALIAS_SIZE) {

        // Verify format for adding alias + command
        if (alias == NULL || command == NULL) {
            printf("not enough commands to create an alias!\n");
            return;
        }

        // Add alias to 2D array
        strcpy(aliases[aliasCount], alias);
        strcat(aliases[aliasCount], " ");
        strcat(aliases[aliasCount], command);
        aliasCount++;
        printf("alias added: %s %s\n", alias, command);

    } else {
        printf("maximum number of aliases reached!\n");
    }
}

void removeAlias(char *alias) {

    int i;
    for (i = 0; i < aliasCount; i++) {


        if (strncmp(aliases[i], alias, strlen(alias)) == 0) {

            // Shift aliases down
            for (int j = i; j < aliasCount - 1; j++) {
                strcpy(aliases[j], aliases[j + 1]);
            }
            aliasCount--;
            printf("alias: '%s' removed successfully!\n", alias);
            return;
        }
    }
    printf("alias not found!\n");
}

char *getAliasCommand(char *alias) {

    // Iterate through aliases until found and separate command
    for (int i = 0; i < aliasCount; i++) {
        if (strncmp(aliases[i], alias, strlen(alias)) == 0) {
            return strtok(aliases[i], " ") + strlen(alias) + 1;
        }
    }
    return NULL;
}

void printAliases() {
    printf("aliases:\n");

    for (int i = 0; i < aliasCount; i++) {

        // Get command from function and print alongside alias for QoL
        char *command = getAliasCommand(aliases[i]);
        printf("%s = %s\n", aliases[i], command);
    }
}

void saveAlias() {

    // Character array for file
    char aliasFilePath[1024];

    // Make file in home directory
    snprintf(aliasFilePath, sizeof(aliasFilePath), "%s/%s", getenv("HOME"), ALIAS_FILE);
    FILE *file = fopen(aliasFilePath, "w");

    // Save aliases and commands into file
    for (int i = 0; i < aliasCount; i++) {
        fprintf(file, "alias %s %s\n", aliases[i], getAliasCommand(aliases[i]));
    }

    fclose(file);
}

void loadAlias() {

    // Character array for file
    char aliasFilePath[1024];

    // Make file in home directory called ALIAS_FILE
    snprintf(aliasFilePath, sizeof(aliasFilePath), "%s/%s", getenv("HOME"), ALIAS_FILE);
    FILE *file = fopen(aliasFilePath, "r");

    // Character array to STORE each from file
    char line[512];

    // Read file until file ends removing new lines
    while (fgets(line, sizeof(line), file) != NULL) {
        line[strcspn(line, "\n")] = 0;

        // Find aliases within file
        if (strncmp(line, "alias ", 6) == 0) {

            // Load aliases and its commands
            char *alias = strtok(line + 6, " ");
            char *command = strtok(NULL, "");

            // Adding to alias list
            addAlias(alias, command);
        }
    }

    fclose(file);
}