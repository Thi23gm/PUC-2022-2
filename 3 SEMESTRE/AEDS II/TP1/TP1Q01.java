import java.util.*;

public class TP1Q01 {
    public static boolean IsFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String isPalindromo(String s){
        String resp = "SIM";
        if(s.length() == 0)
            resp = "NÃO";
        else{
            for(int i = 0, j = s.length() - 1; i < (s.length() / 2); i++, j--){
                if(s.charAt(i) != s.charAt(j))
                    resp = "NÃO";
                    i = s.length();
            }
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
            System.out.println(isPalindromo(str[i])); 
        }
    }
}
