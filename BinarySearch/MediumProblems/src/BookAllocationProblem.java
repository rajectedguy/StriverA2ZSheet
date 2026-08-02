import java.util.Scanner;

public class BookAllocationProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = findPages(arr, k);
        System.out.println(ans);
    }
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
        }
        long low = 0;
        long high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }
        long ans = -1;
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
    private static boolean isPossible(int[] arr, int k, long maxPages) {
        int studentsRequired = 1;
        long currentSum = 0;
        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                studentsRequired++;
                currentSum = pages;
            } else {
                currentSum += pages;
            }
        }
        return studentsRequired <= k;
    }
}