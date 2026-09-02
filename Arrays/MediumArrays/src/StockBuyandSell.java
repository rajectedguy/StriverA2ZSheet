import java.util.Scanner;

public class StockBuyandSell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
    static int maxProfit(int[] prices) {
        int mini =  prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            ans = Math.max(ans, cost);
            mini = Math.min(mini, prices[i]);
        }
        return ans;
    }
}
