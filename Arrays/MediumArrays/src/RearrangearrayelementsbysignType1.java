import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RearrangearrayelementsbysignType1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] ans = brute(arr);
        System.out.println(Arrays.toString(ans));
        int[] ans2 = optimal(arr);
        System.out.println(Arrays.toString(ans2));
    }
    static int[] brute(int[] arr){
        int n=arr.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for (int j : arr) {
            if (j < 0) {
                neg.add(j);
            } else {
                pos.add(j);
            }
        }
        for (int i = 0; i < n/2; i++) {
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }
        return arr;
    }
    static int[] optimal(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        int posindex=0;
        int negindex=1;
        for (int j : arr) {
            if (j < 0) {
               ans[negindex]=j;
               negindex+=2;
            }else  {
                ans[posindex]=j;
                posindex+=2;
            }
        }
        return ans;
    }
}
