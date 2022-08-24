import java.util.*;

public class TT2Q03 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int ano = 0, resp = 1986;
        do {
            ano = 0;
            ano = scn.nextInt();
            if (ano != 0) {
                while (ano >= resp) {
                    resp += 76;
                }
                System.out.println(resp);
            }
        } while (ano != 0);
    }
}
