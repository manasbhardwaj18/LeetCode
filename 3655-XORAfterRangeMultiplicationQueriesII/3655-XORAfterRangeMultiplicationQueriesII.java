// Last updated: 4/9/2026, 12:36:35 PM
1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int MOD = (int)1e9+7, n = nums.length, m = queries.length;
4        int B = (int)Math.sqrt(n);
5        ArrayList<int[]>[][] store = new ArrayList[B+1][B+1];
6
7        for (int i = 0; i < B; i++) {
8            for (int j = 0; j < B; j++) {
9                store[i][j] = new ArrayList<>();                
10            }                                        
11        }
12
13        for (int i = 0; i < m; i++) {
14            int l = queries[i][0], r = queries[i][1];
15            int k = queries[i][2], v = queries[i][3];
16
17            if (k >= B) {
18                for (int idx = l; idx <= r; idx += k) {
19                    nums[idx] = (int)((1L * nums[idx] * v) % MOD);
20                }
21            }else {
22                int remainder = l % k;
23                store[k][remainder].add(new int[]{l, r, v});
24            }
25        }
26
27        for (int k = 1; k < B; k++) {
28            for (int rem = 0; rem < k; rem++) {
29                if (store[k][rem].isEmpty()) continue;
30
31                ArrayList<int[]> queriesList = store[k][rem];
32                int chainLength = (n - rem + k - 1) / k;
33
34                long[] diff = new long[chainLength + 1];
35                Arrays.fill(diff, 1L);
36
37                for (int[] q : queriesList) {
38                    int l = q[0], r = q[1], v = q[2];
39
40                    int startPos = (l - rem) / k;
41                    int endPos = (r - rem) / k;
42                                                             
43                    if (startPos < 0) startPos = 0;
44                    if (endPos >= chainLength) endPos = chainLength - 1;
45                    if (startPos > endPos) continue;
46                    diff[startPos] = (diff[startPos] * v) % MOD;
47                    if (endPos + 1 < chainLength) {
48                    diff[endPos + 1] = (diff[endPos + 1] * modInverse(v, MOD)) % MOD;
49                    }
50                }
51    
52                long curr = 1L;
53                for (int pos = 0; pos < chainLength; pos++) {
54                    curr = (curr * diff[pos]) % MOD;
55                    int idx = rem + pos * k;
56                    nums[idx] = (int)((1L * nums[idx] * curr) % MOD);
57                }
58            }        
59    
60        }
61
62        int res = 0;
63        for (int i = 0; i < n; i++) {
64            res ^= nums[i];
65        }
66
67        return res;
68    }
69    private long modInverse(long a, int MOD) {
70        return pow(a, MOD - 2, MOD);
71    }
72    
73    private long pow(long a, long b, int MOD) {
74        long result = 1;
75        while (b > 0) {
76            if ((b & 1) == 1) {
77                result = (result * a) % MOD;
78            }
79            a = (a * a) % MOD;
80            b >>= 1;
81        }
82        return result;
83     
84    
85    }
86
87}