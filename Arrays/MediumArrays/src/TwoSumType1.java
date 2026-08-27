import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumType1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] ans1 = brute(arr, target);
        System.out.println("Brute: [" + ans1[0] + ", " + ans1[1] + "]");

        int[] ans2 = optimal(arr, target);
        System.out.println("Optimal: [" + ans2[0] + ", " + ans2[1] + "]");
    }
    static int[] brute(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int[] optimal(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int req = target - arr[i];
            if (map.containsKey(req)) {
                return new int[]{map.get(req), i};
            }
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}