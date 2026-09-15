import java.util.*;

public class MergeOverlappingSubintervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[][] ans = brute(arr);
        System.out.println(Arrays.deepToString(ans));
        int[][] ans2 = optimal(arr);
        System.out.println(Arrays.deepToString(ans2));
    }
    private static int[][] brute(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            ans.add(new int[]{start, end});
            i = j;
        }
        return ans.toArray(new int[0][]);
    }
    private static int[][] optimal(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[0][]);
    }
}
