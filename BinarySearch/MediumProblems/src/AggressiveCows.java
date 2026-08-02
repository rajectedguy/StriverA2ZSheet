import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = aggressiveCows(arr, k);
        System.out.println(ans);
    }
    public static int aggressiveCows(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int low = 1;
        int high = arr[n - 1] - arr[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(arr, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean canPlaceCows(int[] arr, int dist, int k) {
        int countCows = 1;
        int lastPos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPos >= dist) {
                countCows++;
                lastPos = arr[i];
            }
            if (countCows >= k) {
                return true;
            }
        }
        return false;
    }
}