import java.util.Scanner;

public class BasicsHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] hash = new int[100];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        int q;
        q = sc.nextInt();
        while (q-- != 0) {
            int number;
            number = sc.nextInt();
            System.out.println(hash[number]);
        }
    }
}
