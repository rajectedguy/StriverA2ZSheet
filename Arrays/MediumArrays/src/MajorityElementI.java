import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElementI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = brute(arr);
        System.out.println(ans);
        int ans1 = better(arr);
        System.out.println(ans1);
        int ans2 = optimal(arr);
        System.out.println(ans2);
    }
    static int brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > arr.length/2) {
                return arr[i];
            }
        }
        return -1;
    }
    static int better(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
    static int optimal(int[] arr) {
        int cnt = 0;
        int el = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cnt == 0){
                cnt++;
                el = arr[i];
            } else if(arr[i] == el){
                cnt++;
            }else {
                cnt--;
            }
        }
        int cnt1 =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == el){
                cnt1++;
            }
        }
        if(cnt1>arr.length/2){
            return el;
        }
        return -1;
    }
}
