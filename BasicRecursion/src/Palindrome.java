import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        boolean palindromeVar = isPalindrome(0,str,len);
        if(palindromeVar){
            System.out.println("palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
    static boolean isPalindrome(int i, String str,int len) {
        if (i >= len/2) return true;
        if (str.charAt(i) != str.charAt(len-1-i)) {
            return false;
        }
        return isPalindrome(i+1, str, len);
    }
}
