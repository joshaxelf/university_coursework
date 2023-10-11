#include <stdio.h>

int main()
{
   int i;
   char name[20];
   char colour[20];

   printf("What is your first name? ");
   scanf("%s", name );

   printf("What is your favourite colour? ");
   scanf("%s", colour);

   printf("What age are you? ");
   scanf("%d", &i);

   printf("%s is %d years old and their favourite colour is %s", name, i, colour);

   return 0;
}
