#include <stdio.h>

int main(void) {
    int id = 0, id1 = 0, id2 = 0, id3 = 0, velho = 0, i = 0;
    do {
        scanf("%d", &id);
        if (id != 0) {
            scanf("%d", &id1);
            scanf("%d", &id2);
            id3 = id - (id1 + id2);
            int todasId[3] = {id1, id2, id3};
            for (i = 0; i < 3; i++) {
                if (todasId[i] > velho) {
                    velho = todasId[i];
                }
            }
            printf("%d\n", velho);
        }
    } while (id != 0);
    return 0;
}