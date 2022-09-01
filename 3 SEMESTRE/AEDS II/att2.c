#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char str1[100], str2[100];
    while (scanf("%s %s", str1, str2) != EOF) {
        int i = 0, j = 0;
        while (i < strlen(str1) || j < strlen(str2)) {
            if (i < strlen(str1))
                printf("%c", str1[i++]);
            if (j < strlen(str2))
                printf("%c", str2[j++]);
        }
        printf("\n");
    }   
    return 0;
}