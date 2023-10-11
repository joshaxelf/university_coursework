#include <stdio.h>

int main(void) {
    char input[10];
    int length = 0;

    printf("Enter a two-digit positive integer: ");
    scanf("%s", input);

    while (input[length] != '\0') {
        length++;
    }

    if (length == 2 && input[0] != '-') {
        printf("The reversal is: %c%c\n", input[1], input[0]);
    } else {
        printf("Invalid input!\n");
        return 1;
    }

    return 0;
}
