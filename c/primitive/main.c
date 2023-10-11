#include <stdio.h>

int main() {
    char c = ('a');
    short s = (10);
    int i = (100);
    long l = (1000);
    float f = (1.1);
    double d = (2.2);
    int myNumbers[11] = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10};
    char str[6] = ("Hello");

    printf("%c, %d, %d, %ld, %f, %lf, %d, %s\n", c, s, i, l, f, d, myNumbers[4], str);

    return 0;
}
