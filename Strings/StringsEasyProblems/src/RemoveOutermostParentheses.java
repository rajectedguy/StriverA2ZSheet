import java.util.Scanner;
import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = removeOuterParentheses(s);
        System.out.println(ans);
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) {
                    ans.append(c);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}