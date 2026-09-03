import java.util.*;

public class LeadersinanArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> list;
        list = brute(arr);
        System.out.println(list);
        ArrayList<Integer> list2;
        list2 = optimal(arr);
        System.out.println(list2);
    }
    static ArrayList<Integer> brute(int[] arr) {
        int len = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (arr[i] < arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(arr[i]);
            }
        }
        return list;
    }
    static ArrayList<Integer> optimal(int[] arr) {
        int len = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for (int i = len-1; i >= 0 ; i--) {
            if (arr[i] > maxi) {
                list.add(arr[i]);
            }
            maxi = Math.max(maxi, arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}
