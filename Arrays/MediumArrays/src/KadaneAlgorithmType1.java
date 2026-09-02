import java.util.Scanner;

public class KadaneAlgorithmType1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = brute(arr);
        System.out.println(ans);
        int ans1 = better(arr);
        System.out.println(ans1);
        int ans2 = optimal(arr);
        System.out.println(ans2);
    }
    static int brute(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum  = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
    static int better(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum  = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
    static int optimal(int[] arr) {
        long sum = 0;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > ans) {
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return (int) ans;
    }
}
