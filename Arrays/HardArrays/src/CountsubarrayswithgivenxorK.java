import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountsubarrayswithgivenxorK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = brute(arr,k);
        System.out.println(ans);
        int ans1 = better(arr,k);
        System.out.println(ans1);
        int ans2 = optimal(arr,k);
        System.out.println(ans2);
    }
    private static int brute(int[] arr,int k){
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = 0;
                for (int k1 = i; k1 <= j; k1++) {
                    x = x ^ arr[k1];
                }
                if (x == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
    private static int better(int[] arr,int k){
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i; j < n; j++) {
                x ^= arr[j];
                if (x == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
    private static int optimal(int[] arr,int k){
        int xr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];
            int x = xr ^ k;
            count += map.getOrDefault(x,0);
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
