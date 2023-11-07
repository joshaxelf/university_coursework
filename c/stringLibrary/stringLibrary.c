#include <stdio.h>

char *str_rev_and_copy(char *dest, const char *str) {

    int length = 0;
    while (str[length] != '\0') {
        length++;
    }

    int i;
    for (i = 0; i < length; i++) {
        dest[i] = str[length - i - 1];
    }
    dest[i] = '\0';

    return dest;

}

int main(void) {

    char str[] = "Hello";
    char dest[100];

    printf("Enter string to be reversed: \n");
    scanf("%s", str);

    str_rev_and_copy(dest, str);

    printf("Reversed string is: %s", dest);

}