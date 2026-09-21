import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans1 = brute(arr);
        int ans2 = better(arr);
        int ans3 = optimal(arr);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
    private static int brute(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                ans = Math.max(ans, product);
            }
        }
        return ans;
    }
    private static int better(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                ans = Math.max(ans, product);
            }
        }
        return ans;
    }
    private static int optimal(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int pref = 1, suff = 1;
        for (int i = 0; i < n; i++) {
            if(pref == 0){
                pref =1;
            }
            if(suff == 0){
                suff =1;
            }
            pref *= nums[i];
            suff *= nums[n-i-1];
            ans = Math.max(ans, Math.max(pref , suff));
        }
        return ans;
    }
}
