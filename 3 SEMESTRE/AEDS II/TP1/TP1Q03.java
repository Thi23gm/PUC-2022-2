import java.util.*;

class TP1Q03{

    public static boolean IsFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String ciframento(String s){
        String resp = "";
        int aux = 0;
        for(int i = 0; i < s.length(); i++){
            aux = s.charAt(i) + 3;
            resp += (char) aux;
        }
        return resp;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] str = new String[1000];
        int numEntradas = 0;

        do{
            str[numEntradas] = scn.nextLine();
        }while(IsFim(str[numEntradas++]) == false );
        numEntradas--;

        for(int i = 0; i < numEntradas; i++){
            System.out.println(ciframento(str[i])); 
        }
    }
}