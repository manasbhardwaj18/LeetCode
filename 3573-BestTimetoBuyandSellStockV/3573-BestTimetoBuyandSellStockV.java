// Last updated: 12/17/2025, 3:19:44 PM
1class Solution {
2    public long maximumProfit(int[] prices, int k) {
3        int n = prices.length;
4        if(n==0){
5            return 0;
6        }
7        long[] profit = new long[k+1];
8        long[] buy = new long[k+1];
9        long[] sell = new long[k+1];
10
11        Arrays.fill(buy, Long.MIN_VALUE);
12        for(int j=0;j<n;j++){
13            long p =prices[j];
14            for(int a = 0;a<k;a++){
15                profit[a] = Math.max(Math.max(profit[a],buy[a+1]+p), sell[a+1] - p);
16                buy[a+1] = Math.max(buy[a+1], profit[a+1] - p);
17                sell[a+1] = Math.max(sell[a+1], profit[a+1]+p);
18            }
19        }
20        long maxProfit = 0;
21        for(long o : profit){
22            maxProfit = Math.max(maxProfit,o);
23        }
24        return maxProfit;
25    }
26}