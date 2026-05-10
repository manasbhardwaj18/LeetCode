// Last updated: 5/10/2026, 10:55:51 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int max = 0;
4        int start = prices[0];
5
6        int len = prices.length;
7
8        for(int i = 1; i<len; i++){
9            if(start < prices[i]) max += prices[i] - start;
10            start = prices[i];
11        }
12        return max;
13    }
14}