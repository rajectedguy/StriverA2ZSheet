import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = arr1.clone();
        brute(arr1);
        System.out.println("Brute: " + Arrays.toString(arr1));
        optimal(arr2);
        System.out.println("Optimal: " + Arrays.toString(arr2));
    }
    static void brute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        int[] tempNums = nums.clone();
        Arrays.sort(tempNums);
        permute(tempNums, 0, all);
        List<List<Integer>> uniquePerms = new ArrayList<>();
        for (List<Integer> list : all) {
            if (!uniquePerms.contains(list)) {
                uniquePerms.add(list);
            }
        }
        List<Integer> current = new ArrayList<>();
        for (int num : nums) {
            current.add(num);
        }
        List<Integer> nextPerm = new ArrayList<>();
        for (int i = 0; i < uniquePerms.size(); i++) {
            if (uniquePerms.get(i).equals(current)) {
                if (i == uniquePerms.size() - 1) {
                    nextPerm = uniquePerms.get(0);
                } else {
                    nextPerm = uniquePerms.get(i + 1);
                }
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nextPerm.get(i);
        }
    }
    static void permute(int[] nums, int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            all.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, all);
            swap(nums, i, start);
        }
    }
    static void optimal(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }
        reverse(nums, ind + 1, n - 1);
    }
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
