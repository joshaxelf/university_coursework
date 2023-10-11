#include <stdio.h>

int main(){

    for (int i = 1; i <= 100 ; i++) {

        if ((i % 5 == 0) && (i % 3 == 0) && (i % 9 == 0)){
            printf("FizzBuzzBop\n");
        } else if ((i % 3 == 0) && (i % 7 == 0) && (i % 9 == 0)){
            printf("FizzBazzBop\n");
        } else if ((i % 5 == 0) && (i % 3 == 0)) {
            printf("FizzBuzz\n");
        } else if ((i % 3 == 0) && (i % 7 == 0)){
            printf("FizzBazz\n");
        } else if ((i % 5 == 0) && (i % 7 == 0)){
            printf("BuzzBazz\n");
        } else if ((i % 3 == 0) && (i % 9 == 0)){
            printf("FizzBop\n");
        } else if ((i % 5 == 0) && (i % 9 == 0)){
            printf("BuzzBop\n");
        } else if ((i % 7 == 0) && (i % 9 == 0)){
            printf("BazzBop\n");
        } else if (i % 9 == 0){
            printf("Bop\n");
        } else if (i % 3 == 0){
            printf("Fizz\n");
        } else if (i % 5 == 0){
            printf("Buzz\n");
        } else if (i % 7 == 0){
            printf("Bazz\n");
        } else if ((i % 5 != 0) && (i % 3 != 0)){
            printf("%d\n", i);
        }
    }
}