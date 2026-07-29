import java.util.Scanner;

public class FloorandCeilinSortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int x = input.nextInt();
        int floor = findFloor(arr, x);
        int ciel = findCeil(arr, x);
        System.out.println(floor + " " + ciel);
    }
    static int findFloor(int[] arr, int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return ans;
    }
    static int findCeil(int[] arr, int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return ans;
    }
}
