// Last updated: 6/24/2026, 5:20:17 PM
1class Solution {
2    private static final long MOD = 1_000_000_007L;
3
4    private long[][] multiply(long[][] A, long[][] B) {
5        int sz = A.length;
6
7        long[][] C = new long[sz][sz];
8
9        for (int i = 0; i < sz; i++) {
10            for (int k = 0; k < sz; k++) {
11                if (A[i][k] == 0) continue;
12
13                long cur = A[i][k];
14
15                for (int j = 0; j < sz; j++) {
16                    if (B[k][j] == 0) continue;
17
18                    C[i][j] = (C[i][j] + cur * B[k][j]) % MOD;
19                }
20            }
21        }
22
23        return C;
24    }
25
26    public int zigZagArrays(int n, int l, int r) {
27        int m = r - l + 1;
28        int sz = 2 * m;
29
30        long[][] T = new long[sz][sz];
31
32        for (int x = 0; x < m; x++) {
33
34            for (int y = x + 1; y < m; y++) {
35                T[x][m + y] = 1;
36            }
37
38            for (int y = 0; y < x; y++) {
39                T[m + x][y] = 1;
40            }
41        }
42
43        long[][] result = new long[sz][sz];
44        for (int i = 0; i < sz; i++) {
45            result[i][i] = 1;
46        }
47
48        long power = n - 1;
49
50        while (power > 0) {
51            if ((power & 1) == 1) {
52                result = multiply(result, T);
53            }
54
55            T = multiply(T, T);
56            power >>= 1;
57        }
58
59        long answer = 0;
60
61        for (int i = 0; i < sz; i++) {
62            long rowSum = 0;
63
64            for (int j = 0; j < sz; j++) {
65                rowSum = (rowSum + result[i][j]) % MOD;
66            }
67
68            answer = (answer + rowSum) % MOD;
69        }
70
71        return (int) answer;
72    }
73}