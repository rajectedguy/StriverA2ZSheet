public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        int idx = searchInsert(arr,target);
        System.out.println(idx);
    }
    private static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid-1;
            }else  {
                low = mid+1;
            }
        }
        return ans;
    }
}