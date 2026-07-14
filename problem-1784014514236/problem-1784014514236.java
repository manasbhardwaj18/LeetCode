// Last updated: 7/14/2026, 1:05:14 PM
1class Solution {
2    public int subsequencePairCount(int[] nums) {
3        final int MOD = 1_000_000_007;
4        final int MAX = 200;
5
6        int[][] dp = new int[MAX + 1][MAX + 1];
7        dp[0][0] = 1;
8
9        for (int x : nums) {
10            int[][] next = new int[MAX + 1][MAX + 1];
11
12            for (int g1 = 0; g1 <= MAX; g1++) {
13                for (int g2 = 0; g2 <= MAX; g2++) {
14                    if (dp[g1][g2] == 0) continue;
15
16                    long ways = dp[g1][g2];
17
18                    next[g1][g2] = (int)((next[g1][g2] + ways) % MOD);
19
20                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
21                    next[ng1][g2] = (int)((next[ng1][g2] + ways) % MOD);
22
23                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
24                    next[g1][ng2] = (int)((next[g1][ng2] + ways) % MOD);
25                }
26            }
27
28            dp = next;
29        }
30
31        long ans = 0;
32
33        for (int g = 1; g <= MAX; g++) {
34            ans = (ans + dp[g][g]) % MOD;
35        }
36
37        return (int)ans;
38    }
39
40    private int gcd(int a, int b) {
41        while (b != 0) {
42            int t = a % b;
43            a = b;
44            b = t;
45        }
46        return a;
47    }
48}