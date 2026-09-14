import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> list1 = brute(arr, target);
        System.out.println("Brute: " + list1);

        List<List<Integer>> list2 = better(arr, target);
        System.out.println("Better: " + list2);

        List<List<Integer>> list3 = optimal(arr, target);
        System.out.println("Optimal: " + list3);
    }
    public static List<List<Integer>> brute(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            if (!ans.contains(temp)) {
                                ans.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> better(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                HashSet<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long required = (long) target - nums[i] - nums[j] - nums[k];
                    if (set.contains(required)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], (int) required, nums[k]);
                        Collections.sort(temp);
                        if (!ans.contains(temp)) {
                            ans.add(temp);
                        }
                    }
                    set.add((long) nums[k]);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> optimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}