// Last updated: 7/5/2026, 11:27:39 AM
1class Solution {
2    public int[] pathsWithMaxScore(List<String> board) {
3        int MOD = 1_000_000_007;
4        int n = board.size();
5
6        int[][] dp = new int[n][n];
7        int[][] ways = new int[n][n];
8
9        for (int[] row : dp) Arrays.fill(row, -1);
10
11        dp[n - 1][n - 1] = 0;
12        ways[n - 1][n - 1] = 1;
13
14        for (int i = n - 1; i >= 0; i--) {
15            for (int j = n - 1; j >= 0; j--) {
16                char c = board.get(i).charAt(j);
17
18                if (c == 'X' || (i == n - 1 && j == n - 1))
19                    continue;
20
21                int best = -1;
22                long cnt = 0;
23
24                int[][] dir = {{1,0},{0,1},{1,1}};
25
26                for (int[] d : dir) {
27                    int x = i + d[0], y = j + d[1];
28
29                    if (x >= n || y >= n || dp[x][y] == -1)
30                        continue;
31
32                    if (dp[x][y] > best) {
33                        best = dp[x][y];
34                        cnt = ways[x][y];
35                    } else if (dp[x][y] == best) {
36                        cnt = (cnt + ways[x][y]) % MOD;
37                    }
38                }
39
40                if (best == -1) continue;
41
42                int val = Character.isDigit(c) ? c - '0' : 0;
43
44                dp[i][j] = best + val;
45                ways[i][j] = (int)(cnt % MOD);
46            }
47        }
48
49        if (dp[0][0] == -1) return new int[]{0,0};
50        return new int[]{dp[0][0], ways[0][0]};
51    }
52}