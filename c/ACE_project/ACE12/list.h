/* list.h */

typedef struct Node {
    char *value;
    struct Node *next;
} Node;

typedef Node **List;

Node *new_node(const char *value);

void delete_node(Node *node);

void push(List list, const char *value);

char *pop(List list);

void print_list(List list);

char *peek(List list);

void add(List list, const char *value);

char *rem(List list);

int is_empty(List list);

void clear(List list);

int size(List list);

int index_of(List list, const char *value);

int contains(List list, const char *value);

char *get_at(List list, int index);

int replace_at(List list, int index, const char *new_value);

List new_list(void);