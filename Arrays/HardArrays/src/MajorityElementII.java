import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> ans = brute(arr);
        System.out.println(ans);
        List<Integer> ans1 = better(arr);
        System.out.println(ans1);
        List<Integer> ans2 = optimal(arr);
        System.out.println(ans2);
    }
    private static List<Integer> brute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(result.isEmpty() || result.get(0) != nums[i] && (result.size() < 2 || result.get(1) != nums[i])){
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    if(nums[j] == nums[i]){
                        count++;
                    }
                }
                if(count > nums.length/3){
                    result.add(nums[i]);
                }
            }
            if(result.size() == 2){
                break;
            }
        }
        return result;
    }
    private static List<Integer> better(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int mini = n / 3 + 1;
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            if (mpp.get(num) == mini) {
                result.add(num);
            }
            if (result.size() == 2) break;
        }
        return result;
    }
    private static List<Integer> optimal(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                el1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                el2 = num;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) count1++;
            else if (nums[i] == el2) count2++;
        }
        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>();
        if (count1 >= mini) result.add(el1);
        if (count2 >= mini) result.add(el2);
        return result;
    }
}