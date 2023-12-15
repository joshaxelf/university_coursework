/* list.c */
#include <stdlib.h>
#include <string.h>
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

    // Find element at end of list
    Node *current = *list;
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