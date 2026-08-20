import java.util.Scanner;

public class Reverseanarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        reverse(arr,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        reverseWith1var(0,arr,n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
    static void reverse(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(arr,l+1,r-1);
    }
    static void reverseWith1var(int i, int[] arr, int n){
        if(i>=n/2){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverseWith1var(i+1,arr,n);
    }
}
