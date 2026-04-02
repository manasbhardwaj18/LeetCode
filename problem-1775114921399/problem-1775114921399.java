// Last updated: 4/2/2026, 12:58:41 PM
1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length, n = coins[0].length;
4        int[][][] dp = new int[m][n][3];
5
6        for(int[][] row : dp){
7            for(int[] col : row){
8                Arrays.fill(col, (int)-1e9);
9            }
10        }
11
12        dp[0][0][1] = 0;
13        dp[0][0][2] = 0;
14        dp[0][0][0] = coins[0][0];
15
16        for(int i=0; i<m; i++){
17            for(int j=0; j<n; j++){
18                for(int k=0; k<3; k++){
19                    if(i>0){
20                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k] + coins[i][j]);
21                    }
22                    if(i>0 && k>0){
23                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]);
24                    }
25                    if(j>0){
26                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k] + coins[i][j]);
27                    }
28                    if(j>0 && k>0){
29                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k-1]);
30                    }
31                }
32            }
33        }
34        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
35
36    }
37}