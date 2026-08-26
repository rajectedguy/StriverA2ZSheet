import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestsubarraywithgivensumKpositives {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int ans = brute(arr,k);
        System.out.println(ans);
        int ans1 = bruteOptimal(arr,k);
        System.out.println(ans1);
        int ans2 = better(arr,k);
        System.out.println(ans2);
        int ans3 = Optimal(arr,k);
        System.out.println(ans3);
    }
    public static int brute(int[] arr,int l){
        int maxi=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if(sum == l){
                    maxi=Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }
    public static int bruteOptimal(int[] arr,int l){
        int maxi=0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum == l){
                    maxi=Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }
    public static int better(int[] arr,int k){
        Map<Long, Integer> map=new HashMap<>();
        long sum=0;
        int maxlen=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum==k){
                maxlen=Math.max(maxlen,i+1);
            }
            long rem =sum - k;
            if(map.containsKey(rem)){
                int len= i - map.get(rem);
                maxlen=Math.max(maxlen,len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return maxlen;
    }
    public static int Optimal(int[] arr,int k){
        int n = arr.length;
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLen;
    }
}