import java.util.Scanner;

public class LargestOddNumberinaString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = largestOddNumber(s);
        System.out.println(ans);
    }
    public static String largestOddNumber(String s) {
        int ind = -1;
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        if (ind == -1) return "";
        i = 0;
        while (i <= ind && s.charAt(i) == '0') i++;
        return s.substring(i, ind + 1);
    }
}