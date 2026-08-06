import java.util.Scanner;

public class PaintersPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = findLargestMinDistance(arr, k);
        System.out.println(ans);
    }
    public static int findLargestMinDistance(int[] arr, int k) {
        int n = arr.length;
        long low = 0;
        long high = 0;
        for (int board : arr) {
            low = Math.max(low, board);
            high += board;
        }
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }
    private static boolean isPossible(int[] arr, int k, long maxBoards) {
        int paintersRequired = 1;
        long currentSum = 0;
        for (int board : arr) {
            if (currentSum + board > maxBoards) {
                paintersRequired++;
                currentSum = board;
            } else {
                currentSum += board;
            }
        }
        return paintersRequired <= k;
    }
}