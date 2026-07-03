// Last updated: 7/3/2026, 1:21:30 PM
1class Solution {
2    int n;
3    int[] dx = {-1, 1, 0, 0};
4    int[] dy = {0, 0, 1, -1};
5
6    public int maximumSafenessFactor(List<List<Integer>> grid) {
7        n = grid.size();
8
9        Queue<int[]> q = new LinkedList<>();
10        int[][] dist = new int[n][n];
11        boolean[][] vis = new boolean[n][n];
12
13        for (int r = 0; r < n; r++) {
14            for (int c = 0; c < n; c++) {
15                if (grid.get(r).get(c) == 1) {
16                    vis[r][c] = true;
17                    q.offer(new int[]{r, c});
18                }
19            }
20        }
21
22        
23        while (!q.isEmpty()) {
24            int[] curr = q.poll();
25            int r = curr[0], c = curr[1];
26
27            for (int d = 0; d < 4; d++) {
28                int nr = r + dx[d];
29                int nc = c + dy[d];
30
31                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
32                if (vis[nr][nc]) continue;
33
34                dist[nr][nc] = dist[r][c] + 1;
35                vis[nr][nc] = true;
36                q.offer(new int[]{nr, nc});
37            }
38        }
39
40  
41        PriorityQueue<int[]> store = new PriorityQueue<>(
42            (a, b) -> b[0] - a[0]
43        );
44
45        boolean[][] vis2 = new boolean[n][n];
46        store.offer(new int[]{dist[0][0], 0, 0});
47
48        while (!store.isEmpty()) {
49            int[] curr = store.poll();
50            int safeE = curr[0];
51            int r = curr[1];
52            int c = curr[2];
53
54            if (vis2[r][c]) continue;
55            vis2[r][c] = true;
56
57            if (r == n - 1 && c == n - 1) return safeE;
58
59            for (int d = 0; d < 4; d++) {
60                int nr = r + dx[d];
61                int nc = c + dy[d];
62
63                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
64                if (vis2[nr][nc]) continue;
65
66                int newSafe = Math.min(safeE, dist[nr][nc]);
67                store.offer(new int[]{newSafe, nr, nc});
68            }
69        }
70
71        return 0;
72    }
73}