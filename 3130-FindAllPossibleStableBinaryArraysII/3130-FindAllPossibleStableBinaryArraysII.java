// Last updated: 3/10/2026, 12:45:21 PM
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        int MOD = 1000000007;
4
5        long[][][] dp = new long[zero+1][one+1][2];
6        for(int i=1; i<= Math.min(zero,limit); i++){
7            dp[i][0][0] = 1;
8        }
9
10        for(int j =1; j<= Math.min(one,limit); j++){
11            dp[0][j][1] = 1;
12        }
13
14        for(int i=1; i<=zero; i++){
15            for(int j=1; j<=one; j++){
16                long a = (i-limit>=1) ? dp[i-limit-1][j][1] : 0;
17                long b = (j-limit>=1) ? dp[i][j-limit-1][0] : 0;
18
19                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1] - a + MOD) % MOD;
20                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1] - b + MOD) % MOD;
21            }
22        }
23        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
24    }
25}