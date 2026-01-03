// Last updated: 1/3/2026, 12:58:44 PM
1class Solution {
2    public int numOfWays(int n) {
3        final int MOD = 1000000007;
4        long a = 6, b = 6;
5        for(int m = 2; m <= n ; m++ ){
6            long new_a = (3*a + 2*b) % MOD;
7            long new_b = (2*a + 2*b) % MOD;
8            a = new_a;
9            b = new_b;
10        }
11        return (int)((a+b) % MOD);
12    }
13}