/* list.h */

typedef struct Node {
    char *value;
    struct Node *next;
} Node;

Node *new_node(const char *value);