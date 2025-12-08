// Last updated: 12/8/2025, 1:59:26 PM
1class Solution {
2    public int tribonacci(int n) {
3        if(n==0){
4            return 0;
5        }else if(n==1 || n==2){
6            return 1;
7        }
8        int[] dp = new int[n+1];
9        dp[1] = 1;
10        dp[2] = 1;
11
12        for(int i=3;i<=n;i++){
13            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
14        }
15        return dp[n];
16    }
17}