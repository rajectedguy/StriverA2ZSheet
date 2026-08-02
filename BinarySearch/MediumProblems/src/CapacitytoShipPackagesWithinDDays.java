import java.util.Scanner;

public class CapacitytoShipPackagesWithinDDays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        int days = input.nextInt();
        int ans =shipWithinDays(arr, days);
        System.out.println(ans);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }
        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShipInDays(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private static boolean canShipInDays(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentWeight = 0;
        for (int w : weights) {
            if (currentWeight + w > capacity) {
                daysNeeded++;
                currentWeight = 0;
            }
            currentWeight += w;
        }
        return daysNeeded <= days;
    }
}