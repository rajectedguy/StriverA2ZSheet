import java.util.Arrays;
import java.util.Scanner;

public class Sortanarrayof0s1sand2s {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        brute(arr);
        System.out.println(Arrays.toString(arr));
        better(arr);
        System.out.println(Arrays.toString(arr));
        optimal(arr);
        System.out.println(Arrays.toString(arr));
    }
    static  void brute(int[] arr){
        Arrays.sort(arr);
    }
    static void better(int[] arr){
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            }else {
                c2++;
            }
        }
        for (int i = 0; i < c0; i++) {
            arr[i] = 0;
        }
        for (int i = c0; i < c0+c1; i++) {
            arr[i] = 1;
        }
        for (int i = c0+c1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }
    static void optimal(int[] arr){
        // Dutch national flag algo
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            }else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
