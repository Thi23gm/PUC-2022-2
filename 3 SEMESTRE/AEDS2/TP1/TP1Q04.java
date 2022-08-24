import java.util.*;

class TP1Q04{

    public static boolean IsFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String alteracao(String s, char c1, char c2){
        String resp = "";
        int aux = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c1){
                resp += c2;
            }else{
                aux = s.charAt(i);
                resp += (char) aux;
            }
        }
        return resp;
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String[] str = new String[1000];
        int numEntradas = 0;
        char c1, c2;
        Random gerador = new Random();
        gerador.setSeed(4);

        do{
            str[numEntradas] = scn.nextLine();
        }while(IsFim(str[numEntradas++]) == false );
        numEntradas--;

        for(int i = 0; i < numEntradas; i++){
            c1 = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
            c2 = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
            System.out.println(alteracao(str[i], c1, c2));
        }
    }
}