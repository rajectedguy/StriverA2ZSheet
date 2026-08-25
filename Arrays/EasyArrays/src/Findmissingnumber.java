import java.util.Scanner;

public class Findmissingnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Brute: " + brute(arr, n));
        System.out.println("Better: " + better(arr, n));
        System.out.println("Optimal: " + optimal(arr, n));
        System.out.println("OptimalXor: " + optimalXOR(arr, n));
    }
    static int brute(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int val : arr) {
                if (val == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }
    static int better(int[] arr, int n) {
        int[] hash = new int[n + 1];
        for (int val : arr) hash[val]++;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }
    static int optimal(int[] arr, int n) {
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    static int optimalXOR(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
            xor1 ^= (i + 1);
        }
        xor1 ^= n;
        return xor1 ^ xor2;
    }
}