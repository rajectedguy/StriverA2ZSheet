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
    private static int findFloor(int[] arr, int x) {
        int floor = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                floor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }
    private static int findCeil(int[] arr, int x) {
        int ceil = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ceil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }
}
