
public class calculo {

    int pos[];
    int num_pos;
    float somatorio;
    int num_parenteses;
    public float getSomatorio() {
        return somatorio;
    }

    public calculo(String conta, String a, String b) {
        num_pos = 0;
        pos = new int[10];
        somatorio = 0;
        float largura = 0.00000F;
        float af, bf;
        int n = 1000; // DEFINIR DEPOIS
        num_parenteses = 0;
    

        /////////////////
        af = calcular(a);
        num_pos = 0;
        bf = calcular(b);
        num_pos = 0;
        /////////////////
        largura = (bf - af) / n;
        System.out.println("a:" + af + " b:" + bf + " largura:" + largura);
        for (float i = af; i < bf - largura; i += largura) {
            System.out.println("----------------------------------------------------------");
            String conta2 = conta.replaceAll("x", String.valueOf(i));

            // System.out.println("Altura = "+ calcular(conta2)+ " Largura = " + largura);
            somatorio += calcular(conta2) * largura;
            num_pos = 0;
        }
        System.out.println("SOMATORIO = " + somatorio);
    }

    float calcular(String conta) {
        num_pos++;
        System.out.println("COMEÇOU METODDO CALCULA");
        System.out.println("PROFUNDIDADE (num_pos):" + num_pos);
        pos[num_pos] = 0;
        float numeros[] = new float[10];

        int qtd_numeros = 0;
        char Simbolos[] = new char[10];
        int qtd_simbolos = 0;
        float resultado = 0.00000F;
        int negativo = 0;
        int seno = 0;
        int coseno = 0;
        int exp = 0;

        for (; pos[num_pos] < conta.length(); pos[num_pos]++) {
            System.out.println("COMEÇOU RODAGEM DO FOR DE CALCULA pos:" + pos[num_pos]);
            System.out.println("Letra do For lida: " + conta.charAt(pos[num_pos]));
            System.out.println("CONTA " + conta);
            if(conta.charAt(pos[num_pos]) == 'd'){
                break;
            }
            if (conta.charAt(pos[num_pos]) == '(') {
                String conta2 = novaString(conta);
                System.out.println("TESTE DA NOVA STRING" + conta2);

                if (negativo == 1) {
                    numeros[qtd_numeros] = -calcular(conta2);

                    negativo = 0;
                } else {
                    numeros[qtd_numeros] = calcular(conta2);
                }

                qtd_numeros++;

            } else if (conta.charAt(pos[num_pos]) >= '0' && conta.charAt(pos[num_pos]) <= '9') {
                System.out.println("ADICIONANDO NUMERO NA POS " + qtd_numeros);
                double num_temp = retornaNumero(conta);
                if (seno == 1) {
                    System.out.println("NUMERO PASSADO PRA PEGAR O SENO: " + num_temp);
                    num_temp = Math.toRadians(num_temp);
                    num_temp = Math.sin(num_temp);
                    System.out.println(" SENO É: " + (float) num_temp);
                    seno = 0;
                } else if (coseno == 1) {
                    System.out.println("NUMERO PASSADO PRA PEGAR O COSENO: " + num_temp);
                    num_temp = Math.toRadians(num_temp);
                    num_temp = Math.cos(num_temp);
                    System.out.println(" COSENO É: " + (float) num_temp);
                    coseno = 0;
                }else if(exp == 1){

                    num_temp = Math.exp(num_temp);
                System.out.println("EXPONENCIAL: " + num_temp);
                }
                if (negativo == 1) {
                    num_temp = -num_temp;
                    negativo = 0;
                }
                numeros[qtd_numeros] = (float) num_temp;
                // System.out.println("NUMERO ADICIONADO: " + numeros[qtd_numeros]);
                qtd_numeros++;
                if(conta.charAt(pos[num_pos]) == 'd'){
                    break;
                }
            }
            if (pos[num_pos] >= conta.length()) {
                break;
            } else if (conta.charAt(pos[num_pos]) == '+') {
                System.out.println("+ ADICIONADO");
                Simbolos[qtd_simbolos] = '+';
                qtd_simbolos++;
            } else if (conta.charAt(pos[num_pos]) == '-') {
                System.out.println("- ADICIONADO");
                negativo = 1;
                if (qtd_simbolos != qtd_numeros) {
                    Simbolos[qtd_simbolos] = '+';
                    qtd_simbolos++;
                }

            } else if (conta.charAt(pos[num_pos]) == '/') {
                System.out.println("/ ADICIONADO");
                Simbolos[qtd_simbolos] = '/';
                qtd_simbolos++;
            } else if (conta.charAt(pos[num_pos]) == '^') {
                System.out.println("* ADICIONADO");
                Simbolos[qtd_simbolos] = '^';
                qtd_simbolos++;
            } else if (conta.charAt(pos[num_pos]) == '*') {
                System.out.println("* ADICIONADO");
                Simbolos[qtd_simbolos] = '*';
                qtd_simbolos++;
            } else if (conta.charAt(pos[num_pos]) == 's' && conta.charAt(pos[num_pos] + 1) == 'e'
                    && conta.charAt(pos[num_pos] + 2) == 'n') {
                pos[num_pos] += 2;
                seno = 1;
            } else if (conta.charAt(pos[num_pos]) == 'c' && conta.charAt(pos[num_pos] + 1) == 'o'
                    && conta.charAt(pos[num_pos] + 2) == 's') {
                pos[num_pos] += 2;
                coseno = 1;
            } else if (conta.charAt(pos[num_pos]) == '#'){

                numeros[qtd_numeros] = (float) Math.PI;
                qtd_numeros++;
            }else if (conta.charAt(pos[num_pos]) == 'e'){

                
                exp++;
               
            }

        }

        for (int i = 0; i < qtd_simbolos; i++) {
            if (Simbolos[i] == '*') {

                System.out.println(" MULTIPLICACAO REALIZADA ENTRE: " + numeros[i] + " e " +
                        numeros[i + 1]);

                numeros[i + 1] = numeros[i] * numeros[i + 1];
                numeros[i] = 0;
                Simbolos[i] = '+';
            } else if (Simbolos[i] == '/') {
                System.out.println(" DIVISAO REALIZADA ENTRE: " + numeros[i] + " e " +
                        numeros[i + 1]);

                numeros[i + 1] = numeros[i] / numeros[i + 1];
                numeros[i] = 0;
                Simbolos[i] = '+';
            } else if (Simbolos[i] == '^') {
                System.out.println(" ELEVAÇÃO REALIZADA ENTRE: " + numeros[i] + " e " +
                        numeros[i + 1]);
                numeros[i + 1] = (float) Math.pow(numeros[i], numeros[i + 1]);
                numeros[i] = 0;
                Simbolos[i] = '+';

            }

        }
        for (int i = 0; i < qtd_simbolos; i++) {

            if (Simbolos[i] == '+') {

                System.out.println("i =" + i + " SOMA REALIZADA ENTRE: " + numeros[i] + " e " +
                        numeros[i + 1]);
                numeros[i + 1] = numeros[i] + numeros[i + 1];
                numeros[i] = 0;
            }

        }
        resultado = numeros[qtd_numeros - 1];
        System.out.println("O RESULTADO DA CONTA É: " + resultado);
        System.out.println("num_pos " + num_pos);
        System.out.println("pos[num] " + pos[num_pos]);
        num_pos--;
        return resultado;

    }

    float retornaNumero(String conta) {
        String numero = "";

        do {
            numero += conta.charAt(pos[num_pos]);

            if (pos[num_pos] + 1 >= conta.length()) {
                break;
            }
            pos[num_pos]++;
        } while ((conta.charAt(pos[num_pos]) >= '0' && conta.charAt(pos[num_pos]) <= '9')
                || ((conta.charAt(pos[num_pos]) == '.') || (conta.charAt(pos[num_pos]) == ',')));
        // System.out.println("POS Q SAIU = " + pos[num_pos]);
        // System.out.println("char: " + conta.charAt(pos[num_pos]));

        return Float.parseFloat(numero);
    }

    String novaString(String s) {
        String nova = "";
        num_parenteses++;
        pos[num_pos]++;
        do {
            if (s.charAt(pos[num_pos]) == '(') {
                num_parenteses++;
            }
            
            nova += s.charAt(pos[num_pos]);
            
            if(s.charAt(pos[num_pos]+1) == ')'){
                num_parenteses--;
            }
            pos[num_pos]++;
        } while (s.charAt(pos[num_pos]) != ')' || num_parenteses != 0);

        
        return nova;
    }
}
