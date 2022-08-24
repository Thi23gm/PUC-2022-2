#include <stdio.h>
int main(void) {
    int atual = 0, next = 1986;
    do {
        atual = 0;
        scanf("%d", &atual);
        if (atual != 0) {
            while (atual >= next) {
                next += 76;
            }
            printf("%d\n", next);
        }
    } while (atual != 0);

    return 0;
}