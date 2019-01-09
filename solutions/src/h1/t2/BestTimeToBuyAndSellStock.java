package h1.t2;

/**
 * @author zhangshibo
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if(cur < min){
                min = cur;
                continue;
            }
            int profit = cur - min;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] src = {7, 2, 5, 3, 6, 4, 1, 8};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(src));
    }
}
