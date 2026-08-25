import java.util.ArrayList;
import java.util.Scanner;

public class Intersectionoftwosortedarrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int m = input.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = input.nextInt();
        }
        optimal(a, b);
        input.close();
    }
    static void optimal(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            }else if (a[i] > b[j]) {
                j++;
            }else {
                list.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(list);
    }
}
