import java.util.Arrays;
import java.util.Scanner;

public class Mergetwosortedarrayswithoutextraspace {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int[] arr1=new int[m];
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        brute(arr1,m,arr2,n);
        optimal(arr1,m,arr2,n);
    }
    private static void brute(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int l = 0;
        int r = 0;
        int index = 0;
        while (l < m && r < n) {
            if (nums1[l] <= nums2[r]) {
                ans[index++] = nums1[l++];
            } else {
                ans[index++] = nums2[r++];
            }
        }
        while (l < m) {
            ans[index++] = nums1[l++];
        }
        while (r < n) {
            ans[index++] = nums2[r++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
    private static void optimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}