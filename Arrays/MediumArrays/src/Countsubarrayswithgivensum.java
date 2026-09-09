import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Countsubarrayswithgivensum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int ans = brute(arr,k);
        System.out.println(ans);
        int ans1 = better(arr,k);
        System.out.println(ans1);
        int ans2 = optimal(arr,k);
        System.out.println(ans2);
    }
    private static int brute(int[] arr, int k) {
        int count=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum=0;
                for (int l = i; l <= j; l++) {
                    sum+=arr[l];
                }
                if (sum==k) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int better(int[] arr, int k) {
        int count=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int optimal(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        prefixSumCount.put(0, 1);
        for (int j : arr) {
            prefixSum += j;
            int remove = prefixSum - k;
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}