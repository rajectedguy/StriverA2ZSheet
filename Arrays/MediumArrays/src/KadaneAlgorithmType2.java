import java.util.Scanner;

public class KadaneAlgorithmType2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        optimalWithIndices(arr);
    }
    static void optimalWithIndices(int[] arr) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum Subarray Sum: " + max);
        System.out.println("Start Index: " + ansStart + ", End Index: " + ansEnd);
        System.out.print("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}