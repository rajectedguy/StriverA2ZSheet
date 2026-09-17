import java.util.Arrays;
import java.util.Scanner;

public class Findtherepeatingandmissingnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans1=brute(arr);
        System.out.println(Arrays.toString(ans1));
        int[] ans2=better(arr);
        System.out.println(Arrays.toString(ans2));

    }
    private static int[] brute(int[] arr) {
        int[] ans = new int[2];
        int n = arr.length;
        int repeating = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int k : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count == 2) {
                repeating = i;
            }
            if (count == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        ans[0] = repeating;
        ans[1] = missing;
        return ans;
    }
    private static int[] better(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        for (int j : arr) {
            hash[j]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}
