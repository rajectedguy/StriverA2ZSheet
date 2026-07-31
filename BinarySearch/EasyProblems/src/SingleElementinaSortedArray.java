import java.util.Scanner;

public class SingleElementinaSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = singleNonDuplicate(arr);
        System.out.println(ans);
    }
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length,l = 0, r = nums.length - 1;
        if ( n == 1) {
            return nums[0];
        }
        if ( nums[0] != nums[1]) {
            return nums[0];
        }
        if ( nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
                l = mid + 1;
            }  else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
