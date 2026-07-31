import java.util.Scanner;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int found = findMin(arr);
        System.out.println(found);
    }
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
