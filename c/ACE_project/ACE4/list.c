/* list.c */
#include <stdlib.h>
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

void push(Node *head, const char *value) {

    // Find element at end of list
    Node *current = head;
    while (current->next != NULL) {
        current = current->next;
    }

    // Set new Node to end of list
    Node *newNode = new_node(value);
    if (newNode != NULL) {
        current->next = newNode;
    }
}