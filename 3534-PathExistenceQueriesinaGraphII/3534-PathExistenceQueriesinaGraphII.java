// Last updated: 7/10/2026, 6:47:42 PM
1class Solution {
2    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3
4        int[][] sortedNums = new int[n][2];
5        for (int i = 0; i < n; i++) {
6            sortedNums[i][0] = nums[i];
7            sortedNums[i][1] = i;
8        }
9
10        Arrays.sort(sortedNums, Comparator.comparingInt(a -> a[0]));
11
12        int[] point = new int[n];
13        for (int i = 0; i < n; i++) {
14            point[sortedNums[i][1]] = i;
15        }
16
17        int[] up = new int[n + 1];
18        int j = 0;
19
20        for (int i = 0; i < n; i++) {
21            while (j + 1 < n && sortedNums[j + 1][0] - sortedNums[i][0] <= maxDiff) {
22                j++;
23            }
24            if (j < i) j = i;
25            up[i] = j;
26        }
27
28        int temp = n;
29        int k = 0;
30        while (temp != 0) {
31            k++;
32            temp /= 2;
33        }
34
35        int[][] dp = new int[n + 1][k + 1];
36
37        for (int i = 0; i < n; i++) {
38            dp[i][0] = up[i];
39        }
40
41        for (int col = 1; col < k; col++) {
42            for (int i = 0; i < n; i++) {
43                dp[i][col] = dp[dp[i][col - 1]][col - 1];
44            }
45        }
46
47        int[] ans = new int[queries.length];
48        int idx = 0;
49
50        for (int[] q : queries) {
51            int u = q[0], v = q[1];
52
53            if (u == v) {
54                ans[idx++] = 0;
55                continue;
56            }
57
58            int st = Math.min(point[u], point[v]);
59            int en = Math.max(point[u], point[v]);
60
61            if (up[st] == st) {
62                ans[idx++] = -1;
63                continue;
64            }
65
66            int node = st;
67            int step = 0;
68
69            for (int i = k - 1; i >= 0; i--) {
70                if (dp[node][i] < en) {
71                    node = dp[node][i];
72                    step += (1 << i);
73                }
74            }
75
76            if (up[node] < en)
77                ans[idx++] = -1;
78            else
79                ans[idx++] = step + 1;
80        }
81
82        return ans;
83    }
84}