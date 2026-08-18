import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrintAllDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            arr.add(i);
            if((n % i) != 0) {
                arr.add(n / i);
            }
        }
        Collections.sort(arr);
        arr.forEach(System.out::println);
    }
}
