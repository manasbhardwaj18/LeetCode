// Last updated: 7/8/2026, 12:32:32 PM
1class Solution {
2    public int[] sumAndMultiply(String s, int[][] queries) {
3        int n = s.length();
4        int m = queries.length;
5        long MOD = 1000000007L;
6
7        long[] prefSum = new long[n + 1];
8        long[] prefVal = new long[n + 1];
9        int[] prefCnt = new int[n + 1];
10        long[] power = new long[n + 1];
11
12        power[0] = 1;
13
14        for (int i = 1; i <= n; i++) {
15            power[i] = (power[i - 1] * 10) % MOD;
16        }
17
18        for (int i = 0; i < n; i++) {
19            int d = s.charAt(i) - '0';
20
21            prefSum[i + 1] = prefSum[i] + d;
22            prefCnt[i + 1] = prefCnt[i] + (d != 0 ? 1 : 0);
23
24            if (d == 0) {
25                prefVal[i + 1] = prefVal[i];
26            } else {
27                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
28            }
29        }
30
31        int[] result = new int[m];
32
33        for (int i = 0; i < m; i++) {
34            int l = queries[i][0];
35            int r = queries[i][1];
36
37            int len = prefCnt[r + 1] - prefCnt[l];
38
39            long start = prefVal[l];
40            long end = prefVal[r + 1];
41
42            long x = (end - (start * power[len]) % MOD + MOD) % MOD;
43            long sum = prefSum[r + 1] - prefSum[l];
44
45            result[i] = (int) ((x * sum) % MOD);
46        }
47
48        return result;
49    }
50}