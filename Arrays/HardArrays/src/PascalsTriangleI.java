import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangleI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> triangle = generate(n);
        System.out.println(triangle);
    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            triangle.add(generateRow(i));
        }
        return triangle;
    }
    private static List<Integer> generateRow(int Row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int col = 1; col < Row; col++) {
            ans = ans * (Row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }
}
