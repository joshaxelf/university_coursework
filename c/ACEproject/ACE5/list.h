/* list.h */

typedef struct Node {
    char *value;
    struct Node *next;
} Node;

typedef Node** List;

Node *new_node(const char *value);

void delete_node(Node *node);

void push(List list, const char *value);

List new_list(void);