#include <stdio.h>

int str_len(char *str);

void str_cpy(char *src, char *dest);

int main() {

    char *str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    printf("%s is %d characters long!\n", str, str_len(str));

    char str2[100] = "XXXXXXXXXXXXXXXXXXXXXXXXXX   If you're reading this, you probably forgot a '\\0'!";

    str_cpy(str, str2);

    printf("Copied from:\t%s\nCopied to:\t%s", str, str2);

}

int str_len(char *str) {

    int length = 0;

    while (*str != '\0') {
        length++;
        str++;
    }

    return length;
}

void str_cpy(char *src, char *dest) {

    while (*src != '\0') {
        *dest = *src;
        src++;
        dest++;
    }

    // REMEMBER TO ADD NULL
    *dest = '\0';
}