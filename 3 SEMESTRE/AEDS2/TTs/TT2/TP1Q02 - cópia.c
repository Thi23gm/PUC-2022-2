#include <ctype.h>
#include <stdio.h>
#include <string.h>

int main() {
    char frase[100];
    int i = 0, j = 0, aux = 0, TAM = 0, valor = 1;

    while (valor != 0) {
        memset(frase, 0, sizeof(frase));
        char end[4] = "FIM";
        j = 0;
        valor = 0;
        fgets(frase, 100, stdin);

        if ((strlen(frase) > 0) && (frase[strlen(frase) - 1] == '\n'))
            frase[strlen(frase) - 1] = '\0';

        valor = strcmp(frase, end);
        if (valor != 0) {
            TAM = strlen(frase) - 1;

            for (i = 0; i <= TAM; i++) {
                frase[i] = tolower(frase[i]);
            }
            for (i = 0; i <= TAM; i++) {
                if (frase[i] == ' ') {
                    for (j = i; j <= TAM; j++) {
                        frase[j] = frase[j + 1];
                    }
                }
            }
            TAM = strlen(frase) - 1;

            for (int i = 0, j; frase[i] != '\0'; ++i) {
                while (!(frase[i] >= 'a' && frase[i] <= 'z') && !(frase[i] == '\0') && !(frase[i] >= '0' && frase[i] <= '9')) {
                    for (j = i; frase[j] != '\0'; ++j) {
                        frase[j] = frase[j + 1];
                    }
                    frase[j] = '\0';
                }
            }
            TAM = strlen(frase) - 1;

            for (i = 0; i <= TAM; i++) {
                if (frase[i] != frase[TAM]) {
                    aux++;
                }
                TAM--;
            }
            if (aux != 0) {
                printf("NAO\n");
            } else {
                printf("SIM\n");
            }
        }
    }

    return 0;
}