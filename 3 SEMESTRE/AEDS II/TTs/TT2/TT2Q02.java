import java.util.*;

public class TT2Q02 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        int id = 0, id1 = 0, id2 = 0, id3 = 0, id4 = 0, i = 0;
        do {
            id = sc.nextInt();
            if (id != 0) {
                id1 = sc.nextInt();
                id2 = sc.nextInt();
                id3 = id - (id1 + id2);
                int allId[] = { id1, id2, id3 };
                for (i = 0; i < 3; i++) {
                    if (allId[i] > id4) {
                        id4 = allId[i];
                    }
                }
                System.out.println(id4);
            }
        } while (id != 0);
    }

}
