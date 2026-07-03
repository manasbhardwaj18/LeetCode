// Last updated: 7/3/2026, 1:18:43 PM
1class Solution {
2    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
3        int m = grid.size();
4        int n = grid.get(0).size();
5
6        int[][] dist = new int[m][n];
7        for (int[] row : dist)
8            Arrays.fill(row, Integer.MAX_VALUE);
9
10        Deque<int[]> dq = new ArrayDeque<>();
11
12        dist[0][0] = grid.get(0).get(0);
13        dq.offerFirst(new int[]{0, 0});
14
15        int[] dx = {-1, 1, 0, 0};
16        int[] dy = {0, 0, -1, 1};
17
18        while (!dq.isEmpty()) {
19            int[] curr = dq.pollFirst();
20            int x = curr[0];
21            int y = curr[1];
22
23            if (x == m - 1 && y == n - 1)
24                return dist[x][y] < health;
25
26            for (int k = 0; k < 4; k++) {
27                int nx = x + dx[k];
28                int ny = y + dy[k];
29
30                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
31                    continue;
32
33                int w = grid.get(nx).get(ny);
34
35                if (dist[x][y] + w < dist[nx][ny]) {
36                    dist[nx][ny] = dist[x][y] + w;
37
38                    if (w == 0)
39                        dq.offerFirst(new int[]{nx, ny});
40                    else
41                        dq.offerLast(new int[]{nx, ny});
42                }
43            }
44        }
45
46        return dist[m - 1][n - 1] < health;
47    }
48}