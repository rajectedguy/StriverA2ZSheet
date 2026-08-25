import java.util.*;

public class Unionoftwosortedarrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int m = input.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = input.nextInt();
        }
        brute(a, b);
        optimal(a, b);
        input.close();
    }
    static void brute(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int val : arr1) {
            set1.add(val);
        }
        for (int val : arr2) {
            set1.add(val);
        }
        int[] union = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            union[index++] = num;
        }
        Arrays.sort(union);
        for (int num : union) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    static void optimal(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (list.isEmpty() || list.getLast() != arr1[i]) {
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if (list.isEmpty() || list.getLast() != arr2[j]) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (list.isEmpty() || list.getLast() != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (list.isEmpty() || list.getLast() != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }
        System.out.println(list);
    }
}