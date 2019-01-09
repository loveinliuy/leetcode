package h1.t2;

/**
 * @author zhangshibo
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
//        int[] given = {7, 1, 5, 3, 6, 4, 8};
//        int[] given = {7, 6, 4, 3, 1};
        int[] given = {1, 2, 3, 4, 5};
//        int[] given = {6, 1, 2, 3, 5, 6, 4, 2, 8};
//        int[] given = {2, 1, 2, 0, 1};
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(given));
    }

}
