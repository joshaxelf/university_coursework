/* list.c */
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "list.h"

Node *new_node(const char *value) {
    Node *myNode = (Node *) malloc(sizeof(Node));

    if (myNode == NULL) {
        return NULL;
    }

    // Get length of the value string
    int length = 0;
    while (value[length] != '\0') {
        length++;
    }

    // Allocate memory and copy the string
    myNode->value = (char *) malloc((length + 1) * sizeof(char));

    // Verify memory allocation
    if (myNode->value == NULL) {
        free(myNode);
        return NULL;
    }

    // Copy the characters
    for (int i = 0; i <= length; i++) {
        myNode->value[i] = value[i];
    }

    myNode->next = NULL;

    return myNode;
}

void delete_node(Node *node) {

    // Free memory for string and node
    if (node != NULL) {
        free(node->value);
        free(node);

        // Set node to NULL as per criteria
        node = NULL;
    }
}

void push(List list, const char *value) {

    // Point to Node
    Node *current = *list;

    // Find element at end of list
    while (current != NULL && current->next != NULL) {
        current = current->next;
    }

    // Set new Node to end of list
    Node *newNode = new_node(value);
    if (newNode != NULL) {
        if (current == NULL) {

            // Must update pointer
            *list = newNode;
        } else {
            current->next = newNode;
        }
    }
}

List new_list(void) {

    // Make list in memory
    List newList = (List) malloc(sizeof(Node *));

    // If succesfull set to NULL
    if (newList != NULL) {
        *newList = NULL;
    }
    return newList;
}

char *pop(List list) {

    // If List empty, nothing to return
    if (*list == NULL) {
        return NULL;
    }

    // Point to Node
    Node *current = *list;
    Node *previous = NULL;

    // Loop to get to last node
    while (current->next != NULL) {
        previous = current;
        current = current->next;
    }

    // Get value
    char *value = (char *) malloc(strlen(current->value) + 1);

    // Copy string over
    if (value != NULL) {
        for (size_t i = 0; current->value[i] != 0; i++) {
            value[i] = current->value[i];
        }
        // Remember null terminator
        value[strlen(current->value)] = '\0';
    }

    // Remove last node
    if (previous != NULL) {
        previous->next = NULL;
    } else {
        *list = NULL;  // The list had only one element
    }

    // Delete last node
    delete_node(current);

    return value;
}

void print_list(List list) {

    // Print opening bracket regardless
    printf("[");

    // Point to Node
    Node *current = *list;

    while (current != NULL) {
        // Print value REMEMBER QUOTES
        printf("\"%s\"", current->value);

        // Remember to print comma
        if (current->next != NULL) {
            printf(", ");
        }

        current = current->next;
    }

    // Add close bracket
    printf("]\n");
}

char *peek(List list) {

    // If List is empty, nothing to peek
    if (*list == NULL) {
        return NULL;
    }

    // Point to Node
    Node *current = *list;

    // Loop for last node
    while (current->next != NULL) {
        current = current->next;
    }

    // Get value
    char *value = (char *) malloc(strlen(current->value) + 1);

    // Copy the string over
    if (value != NULL) {
        for (size_t i = 0; current->value[i] != '\0'; i++) {
            value[i] = current->value[i];
        }
        value[strlen(current->value)] = '\0';
    }

    return value;
}

void add(List list, const char *value) {

    Node *newNode = new_node(value);
    if (newNode != NULL) {
        newNode->next = *list;
        *list = newNode;
    }
}

char *rem(List list) {

    // If list empty, nothing to remove
    if (*list == NULL) {
        return NULL;
    }

    // Point to Node
    Node *current = *list;
    *list = current->next;

    // Get value
    char *value = (char *) malloc(strlen(current->value) + 1);

    if (value != NULL) {
        // Copy the string over
        for (size_t i = 0; current->value[i] != '\0'; i++) {
            value[i] = current->value[i];
        }
        value[strlen(current->value)] = '\0';
    }

    // Delete last node
    delete_node(current);

    return value;
}