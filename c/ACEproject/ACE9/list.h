/* list.h */

typedef struct Node {
    char *value;
    struct Node *next;
} Node;

typedef Node** List;

Node *new_node(const char *value);

void delete_node(Node *node);

void push(List list, const char *value);

char* pop(List list);

void print_list(List list);

char* peek(List list);

void add(List list, const char* value);

char* rem(List list);

List new_list(void);