import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twoSumType2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        boolean ans1 = brute(arr, target);
        System.out.println("Brute: " + ans1);

        boolean ans2 = better(arr, target);
        System.out.println("Better: " + ans2);

        boolean ans3 = optimal(arr.clone(), target);
        System.out.println("Optimal: " + ans3);
    }

    static boolean brute(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean better(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int req = target - arr[i];
            if (map.containsKey(req)) {
                return true;
            } else {
                map.put(arr[i], i);
            }
        }
        return false;
    }

    static boolean optimal(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
