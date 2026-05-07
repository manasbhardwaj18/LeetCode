// Last updated: 5/7/2026, 10:42:17 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int buyPrice = prices[0];
4        int profit = 0;
5
6        for(int i=1; i < prices.length; i++){
7            if(buyPrice > prices[i]){
8                buyPrice = prices[i];
9            }
10            profit = Math.max(profit, prices[i] - buyPrice);
11        }
12        return profit;
13    }
14}