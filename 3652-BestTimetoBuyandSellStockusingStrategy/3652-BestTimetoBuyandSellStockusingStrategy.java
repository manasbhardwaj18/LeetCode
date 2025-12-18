// Last updated: 12/18/2025, 1:51:26 PM
1class Solution {
2    public long maxProfit(int[] prices, int[] strategy, int k) {
3        long sum = 0,fin = 0;
4        int m = k/2, n = prices.length;
5        long cur = 0, max = 0;
6        for(int i=0;i<m;i++){
7            int total = prices[i]*strategy[i];
8            sum += total;
9            cur += prices[i] - total;
10        }
11        for(int i=m;i<k;i++){
12            int total = prices[i]*strategy[i];
13            sum += total;
14            cur += prices[i] - total -  prices[i-m];
15        }
16        max = Math.max(max,cur);
17        for(int i=k;i<n;i++){
18            int total = prices[i]*strategy[i];
19            sum += total;
20            cur += prices[i]-total-prices[i-m]+prices[i-k]*strategy[i-k];
21            max = Math.max(max,cur);
22        }
23        fin = sum + max;
24        return fin;
25    }
26}