// Last updated: 5/10/2026, 10:56:36 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int max = 0;
4        int start = prices[0];
5
6
7        for(int i = 1; i<prices.length; i++){
8            if(start < prices[i]) max += prices[i] - start;
9            start = prices[i];
10        }
11        return max;
12    }
13}