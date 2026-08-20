import java.util.Scanner;

public class CharacterHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int[] hash = new int[26];
        for (char c : arr) {
            hash[c - 'a']++;
        }
        int q = sc.nextInt();
        while (q-- != 0) {
            char ch = sc.next().charAt(0);
            System.out.println(hash[ch - 'a']);
        }
    }
}
