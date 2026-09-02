import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RearrangearrayelementsbysignType2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] ans = brute(arr);
        System.out.println(Arrays.toString(ans));
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

        if(pos.size() > neg.size()){
            for (int i = 0; i < neg.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }
}
