// Last updated: 3/9/2026, 1:50:36 PM
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        int MOD = 1_000_000_007;
4        long[][][] dp = new long[zero+1][one+1][2];
5
6        for(int i=1;i<=Math.min(zero,limit);i++) dp[i][0][0]=1;
7        for(int j=1;j<=Math.min(one,limit);j++) dp[0][j][1]=1;
8
9        for(int i=1;i<=zero;i++){
10            for(int j=1;j<=one;j++){
11                long over0 = (i-limit>=1)? dp[i-limit-1][j][1]:0;
12                long over1 = (j-limit>=1)? dp[i][j-limit-1][0]:0;
13
14                dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1]-over0+MOD)%MOD;
15                dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1]-over1+MOD)%MOD;
16                                                                                                                }
17                                                                                                            }
18
19                                                                                                            return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
20                                                                                                        }                                                                                                                                                          
21}