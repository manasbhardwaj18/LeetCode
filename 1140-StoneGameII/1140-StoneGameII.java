// Last updated: 12/9/2025, 1:29:42 PM
1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[][] dp = new int[n][n+1];
5        int[] suffix = new int[n];
6        suffix[n-1] = piles[n-1];
7
8        for(int i=n-2; i>=0 ; i--){
9            suffix[i] = suffix[i+1] + piles[i];
10        }
11
12        for(int i=n-1;i>=0;i--){
13            for(int m=1;m<= n;m++){
14                if(i+2*m>=n){
15                    dp[i][m]=suffix[i];
16                }else{
17                    for(int x=1;x<=2*m;x++){
18                        dp[i][m] = Math.max(dp[i][m], suffix[i] - dp[i+x][Math.max(m,x)]);
19                    }
20                }
21            }
22        }
23        return dp[0][1];
24    }
25}