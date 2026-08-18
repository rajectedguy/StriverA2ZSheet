import java.util.Scanner;

public class RevereseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int rev = 0;
        while(number!=0){
            int digit = number % 10;
            rev = rev *10+digit;
            number = number / 10;
        }
        System.out.println(rev);
    }
}
