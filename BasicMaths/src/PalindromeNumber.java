import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int orginalNumber = number;
        int rev = 0;
        while(number!=0){
            int digit = number % 10;
            rev = rev *10+digit;
            number = number / 10;
        }
        if(rev==orginalNumber){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
