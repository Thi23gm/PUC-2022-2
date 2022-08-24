public class TP1Q01 {
    public static boolean isFim(String str, int i){
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean verPalindromo(String str){
        String str2;
        str2 = new StringBuffer(str).reverse().toString();
        if(str.equals(str2)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        boolean resp;
        int i = 0;
        String vet[];
        vet = new String[1000];
        String str = "";
        do{
            str = MyIO.readLine();
            resp = verPalindromo(str);
            if(resp == true){
                System.out.println("SIM");
            }
            else{
                System.out.println("NAO");
            }
            i++;
        }while(isFim(str, i) != true );
    }
}