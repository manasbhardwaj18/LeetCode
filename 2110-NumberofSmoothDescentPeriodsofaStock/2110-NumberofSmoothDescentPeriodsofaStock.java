// Last updated: 12/15/2025, 11:28:48 AM
1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long ans = 0;
4        int count = 1;
5        for(int i=0;i<prices.length;i++){
6            if(i==0){
7                ans += count;
8                continue;
9            }
10            if(prices[i] == prices[i-1]-1){
11                count++;
12            }else{
13                count = 1;
14            }
15            ans += count;
16        }
17        return ans;
18    }
19}