// Last updated: 12/31/2025, 1:48:55 PM
1class Solution {
2    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
3    private int rows, cols;
4                
5    public int latestDayToCross(int row, int col, int[][] cells) {
6        this.rows = row;
7        this.cols = col;
8                                            
9        int left = 1, right = cells.length, answer = 0;
10        while (left <= right) {
11            int mid = left + (right - left) / 2;
12            if (canCross(mid, cells)) {
13                answer = mid;
14                left = mid + 1;
15            } else {
16                right = mid - 1;
17            }
18        }
19
20        return answer;
21    }
22    
23    private boolean canCross(int day, int[][] cells) {
24        int[][] grid = new int[rows][cols];
25
26        for (int i = 0; i < day; i++) {
27            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
28        }
29
30        Queue<int[]> queue = new LinkedList<>();
31        boolean[][] visited = new boolean[rows][cols];
32
33        for (int c = 0; c < cols; c++) {
34            if (grid[0][c] == 0) {
35                queue.offer(new int[]{0, c});
36                visited[0][c] = true;
37            }
38        }
39
40        while (!queue.isEmpty()) {
41            int[] curr = queue.poll();
42            int r = curr[0], c = curr[1];
43
44            if (r == rows - 1) return true;
45            for (int[] dir : directions) {
46                int nr = r + dir[0];
47                int nc = c + dir[1];
48
49                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&!visited[nr][nc] && grid[nr][nc] == 0) {
50                    visited[nr][nc] = true;
51                    queue.offer(new int[]{nr, nc});
52                }
53            }
54        }
55
56        return false;
57    }
58}
59