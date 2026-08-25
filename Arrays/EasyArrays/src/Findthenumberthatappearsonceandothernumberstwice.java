import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Findthenumberthatappearsonceandothernumberstwice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans = brute(arr);
        System.out.println(ans);
        int ans1 = better(arr);
        System.out.println(ans1);
        int ans2 = optimal(arr);
        System.out.println(ans2);
    }
    static int brute(int[] arr){
        for (int num : arr) {
            int count = 0;
            for (int i : arr) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return -1;
    }
    static int better(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
    static int optimal(int[] arr){
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}
