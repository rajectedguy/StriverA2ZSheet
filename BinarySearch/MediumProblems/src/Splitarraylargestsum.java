import java.util.Scanner;

public class Splitarraylargestsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = splitArray(arr, k);
        System.out.println(ans);
    }
    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private static boolean canSplit(int[] nums, int k, int maxAllowedSum) {
        int count = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                count++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return count <= k;
    }
}