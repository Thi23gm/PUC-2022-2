import java.util.Arrays;
import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        int numEntradas, temp = 0;
        Scanner sn = new Scanner(System.in);
        numEntradas = sn.nextInt();
        int[] vet = new int[numEntradas];
        
            for(int i = 0; i < numEntradas; i++){
                vet[i] = sn.nextInt();
            }
            Arrays.sort(vet);
            for(int i = 0; i < numEntradas; i++){
                System.out.println(vet[i]);
            }
    }
}
