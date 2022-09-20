import java.util.*;

class Q02{
  public static int remove_Duplicates(int a[], int n){
        if (n == 0 || n == 1)
            return n;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1])
                a[j++] = a[i];
        }
        a[j++] = a[n - 1];
        return j;
    }

  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = 0;
    String entrada;
    while(scn.hasNext()){
      n = scn.nextInt();
      int[] vet = new int[n];
      String[] arr = new String [n];
      entrada = scn.nextLine();
      arr = entrada.split(" ");
      for(int i = 0; i < n; i++){
        vet[i] = Integer.parseInt(arr[i]);
      }
      Arrays.sort(vet);
      int x = remove_Duplicates(vet, n);
    }



  }
}
