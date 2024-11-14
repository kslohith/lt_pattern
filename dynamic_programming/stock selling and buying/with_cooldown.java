// Similar to many dp probelms where we have multiple choices each day, but main catch is during memoization, make sure 
// not to add any variables which are propogated through the stack. (for example, we dont want to push the profits in this approach down the stack, make sure when 
// calculating the dp value, we only consider what is known at that point dont bring in prior information for this calculation )

class Solution {
    int[][] dp;
    public int getMaxProfit(int[] prices, int day, int currentPrice) {
        if(day >= prices.length) {
            return 0;
        }
        if(dp[day][currentPrice == -1 ? 0:1] != -1) {
            return dp[day][currentPrice == -1 ? 0:1];
        }
        if(currentPrice == -1){
            // We don't have any stock, again we have 2 choices, either we can buy or choose not to buy
            int new_currentPrice = prices[day];
            int res = Math.max(getMaxProfit(prices, day + 1, new_currentPrice) - prices[day],getMaxProfit(prices, day + 1, currentPrice));
            dp[day][0] = res;
            return dp[day][0];
        }
        else {
            // we can either choose to sell the stock we are holding today or wait for a better price in the future
            int currentprice_after_selling = -1;
            int res = Math.max(getMaxProfit(prices, day + 2, currentprice_after_selling) + prices[day],getMaxProfit(prices, day + 1, currentPrice));
            dp[day][1] = res;
            return dp[day][1];
        }
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i],-1);
        }
       return  getMaxProfit(prices, 0, -1);
    }
}
