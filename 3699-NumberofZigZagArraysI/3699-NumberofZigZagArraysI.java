// Last updated: 6/23/2026, 9:03:55 PM
1class Solution {
2    private static final int MOD = 1000000007;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r-l+1;
6        int dp[] = new int[m];
7        Arrays.fill(dp,1);
8
9        for(int len = 2; len <=n; len++){
10            if((len & 1) == 0){
11                long pref = 0;
12
13                for(int i=0; i<m; i++){
14                    int old = dp[i];
15                    dp[i] = (int) pref;
16                    pref = (pref + old) % MOD;
17                }
18            }else{
19                long suff = 0;
20                for(int i=m-1; i>=0; i--){
21                    int old = dp[i];
22                    dp[i] = (int) suff;
23                    suff = (suff + old) % MOD;
24                }
25            }
26        }
27        long ans = 0;
28        for(int x : dp){
29            ans  = (ans + x) % MOD;
30        }
31        return (int) ((ans*2) % MOD);
32    }
33}