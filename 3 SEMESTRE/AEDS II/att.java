class att{

    public static void printarNum(int num1, int num2){
        String s = "";
        for(int i = num1; i <= num2; i++){
            System.out.print(i);
            s += "" + i;
        }for(int i = s.length() - 1; i >= 0; i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String entrada;
        while((entrada = MyIO.readLine())!= null){
            String arr[] = entrada.split(" ");
            printarNum(Integer.parseInt(arr[0]) , Integer.parseInt(arr[1]));
            entrada = null;
        }
    }
}