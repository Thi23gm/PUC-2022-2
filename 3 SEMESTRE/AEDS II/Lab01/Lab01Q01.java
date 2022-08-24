package Lab01;
import java.util.Scanner;
class Lab01Q01{
    public static boolean IsFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isMaiusculas(char c){
        return (c >= 'A' && c <= 'Z');
    }

    public static int contarLetrasMaiusculas(String str, int pos){
        int resp = 0;
        if(pos < str.length()){
            if(isMaiusculas(str.charAt(pos)) == true){
                resp = 1 + contarLetrasMaiusculas(str, pos + 1);
            }else{
                resp = contarLetrasMaiusculas(str, pos + 1);
            }
        }
        return resp;
    }
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        String[] entrada = new String[1000];
        int numEntrada = 0;
  
        do {
           entrada[numEntrada] = scn.nextLine();
        } while (IsFim(entrada[numEntrada++]) == false);
        numEntrada--;
  
        for(int i = 0; i < numEntrada; i++){
           System.out.println(contarLetrasMaiusculas(entrada[i],0));
        }
     }
}