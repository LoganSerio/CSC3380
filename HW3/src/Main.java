/**
 *  Christopher Serio
 *  CSC 3380
 *  HW3
 *  Due 3/3/2017
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Numbers");
        ArrayList<Integer> arr = new ArrayList<>();
        count = 0;
        while (in.hasNextInt()) {
            arr.add(in.nextInt());
            count += 1;
        }
        findSucc(arr,count-1);
        System.out.println(arr);
    }
    static void findSucc(ArrayList<Integer> cur, int n) {
        if (n == 1 && cur.get(n).equals(9)) {
            cur.set(0,1);
            cur.add(0);
            count += 1;
        }
        else if (cur.get(n).equals(9)) {
            cur.set(n,0);
            findSucc(cur,n-1);
        }
        else {
             cur.set(n,cur.get(n)+1);
        }
    }

}
