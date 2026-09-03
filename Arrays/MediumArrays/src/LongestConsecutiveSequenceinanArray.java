import java.util.*;

public class LongestConsecutiveSequenceinanArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Brute: " + brute(arr));
        System.out.println("Better: " + better(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
    public static boolean linearSearch(int[] array, int x) {
        for (int j : array) {
            if (j == x) return true;
        }
        return false;
    }
    public static int brute(int[] arr) {
        if (arr.length == 0) return 0;
        int longest = 1;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr, x + 1)) {
                x += 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    public static int better(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int longest = 1;
        int currentCount = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastSmaller) {
                currentCount++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                currentCount = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, currentCount);
        }
        return longest;
    }
    public static int optimal(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int longest = 1;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int count = 1;
                int currentNum = x;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}