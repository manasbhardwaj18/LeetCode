// Last updated: 7/3/2026, 12:58:18 PM
1class Solution {
2    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
3        int n = online.length;
4
5        ArrayList<int[]>[] graph = new ArrayList[n];
6        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
7
8        int[] indegree = new int[n];
9
10        for (int[] e : edges) {
11            graph[e[0]].add(new int[]{e[1], e[2]});
12            indegree[e[1]]++;
13        }
14
15        Queue<Integer> q = new ArrayDeque<>();
16        for (int i = 0; i < n; i++)
17            if (indegree[i] == 0)
18                q.offer(i);
19
20        ArrayList<Integer> topo = new ArrayList<>();
21
22        while (!q.isEmpty()) {
23            int u = q.poll();
24            topo.add(u);
25
26            for (int[] edge : graph[u]) {
27                if (--indegree[edge[0]] == 0)
28                    q.offer(edge[0]);
29            }
30        }
31
32        int left = 0, right = 1_000_000_000;
33        int ans = -1;
34
35        while (left <= right) {
36            int mid = left + (right - left) / 2;
37
38            long INF = Long.MAX_VALUE / 4;
39            long[] dp = new long[n];
40            Arrays.fill(dp, INF);
41            dp[0] = 0;
42
43            for (int u : topo) {
44
45                if (dp[u] == INF)
46                    continue;
47
48                if (u != 0 && u != n - 1 && !online[u])
49                    continue;
50
51                for (int[] edge : graph[u]) {
52                    int v = edge[0];
53                    int w = edge[1];
54
55                    if (w < mid)
56                        continue;
57
58                    if (v != n - 1 && !online[v])
59                        continue;
60
61                    dp[v] = Math.min(dp[v], dp[u] + w);
62                }
63            }
64
65            if (dp[n - 1] <= k) {
66                ans = mid;
67                left = mid + 1;
68            } else {
69                right = mid - 1;
70            }
71        }
72
73        return ans;
74    }
75}