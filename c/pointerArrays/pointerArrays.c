#include <stdio.h>

void print_array(int *ptr, int len);

void print_2d_array(char *ptr, int ylen, int xlen);

int main() {

    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    print_array(arr, 10);

    char arr2[4][5] = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'J'},
            {'K', 'L', 'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S', 'T'},
    };

    print_2d_array(*arr2, 4, 5);
}

void print_array(int *ptr, int len) {
    for (int i = 0; i < len; i++) {
        printf("%d", *(ptr + i));
        if (i < len - 1) {
            printf(", ");
        }
    }
    printf("\n");
}

void print_2d_array(char *ptr, int ylen, int xlen) {
    for (int i = 0; i < ylen; i++) {
        for (int j = 0; j < xlen; j++) {
            printf("%c", *(ptr + i * xlen + j));
            if (j < xlen - 1) {
                printf(", ");
            }
        }
        printf("\n");
    }
}