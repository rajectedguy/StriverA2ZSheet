import java.util.Scanner;

public class Findouthowmanytimesthearrayisrotated {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int c = findKRotation(arr);
        System.out.println(c);
    }

    public static int findKRotation(int []nums){
        // Write your code here.
        int idx = -1;
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[high]) {
                if (nums[low] < ans) {
                    idx = low;
                    ans = nums[low];
                }
                break;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] < ans) {
                    idx = low;
                    ans = nums[low];
                }
                low = mid + 1;
            }else {
                if (nums[mid] < ans) {
                    idx = mid;
                    ans = nums[mid];
                }
                high = mid - 1;
            }
        }
        return idx;
    }
}
