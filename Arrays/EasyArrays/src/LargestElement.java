import java.util.Scanner;

public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int largest = arr[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
                index = i;
            }
        }
        System.out.println("Largest element is " + largest + " at index " + index);
        sc.close();
    }
}