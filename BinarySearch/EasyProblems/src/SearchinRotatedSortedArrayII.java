import java.util.Scanner;

public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int target = input.nextInt();
        boolean found = search(arr,target);
        System.out.println(found?"Found":"Not found");
    }
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left = left + 1;
                right = right - 1;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else  {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}