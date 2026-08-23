import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateArraybyOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int first = arr[0];
        for (int j = 1; j < n; j++) {
            arr[j-1] = arr[j];
        }
        arr[arr.length - 1] = first;
        System.out.println(Arrays.toString(arr));
    }
}
