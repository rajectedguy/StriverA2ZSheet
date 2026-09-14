import java.util.Scanner;
import java.util.HashMap;

public class LargestSubarraywithSum0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans1 = brute(arr);
        System.out.println("Brute Force Answer: " + ans1);
        int ans2 = optimal(arr);
        System.out.println("Optimal Answer: " + ans2);
        sc.close();
    }
    public static int brute(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    public static int optimal(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLen = Math.max(maxLen, length);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}