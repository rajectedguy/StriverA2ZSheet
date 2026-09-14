import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> list1 = brute(arr);
        System.out.println(list1);
        List<List<Integer>> list2 = better(arr);
        System.out.println(list2);
        List<List<Integer>> list3 = optimal(arr);
        System.out.println(list3);
    }
    public static List<List<Integer>> brute(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == sum) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }
    public static List<List<Integer>> better(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }
    public static List<List<Integer>> optimal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}