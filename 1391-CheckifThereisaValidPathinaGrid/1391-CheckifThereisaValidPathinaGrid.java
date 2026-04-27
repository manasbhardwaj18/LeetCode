// Last updated: 4/27/2026, 12:59:09 PM
1class Solution {
2    public boolean hasValidPath(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][][] dir = new int[7][][];
7
8        dir[1] = new int[][]{{0,-1}, {0,1}};
9        dir[2] = new int[][]{{-1,0}, {1,0}};
10        dir[3] = new int[][]{{0,-1}, {1,0}};
11        dir[4] = new int[][]{{0,1}, {1,0}};
12        dir[5] = new int[][]{{0,-1}, {-1,0}};
13        dir[6] = new int[][]{{0,1}, {-1,0}};
14
15        boolean[][] visit = new boolean[m][n];
16        Queue<int[]> queue = new LinkedList<>();
17
18        queue.offer(new int[]{0,0});
19        visit[0][0] = true;
20
21        while(!queue.isEmpty()){
22            int[] cur = queue.poll();
23            int r = cur[0], c= cur[1];
24
25            if(r== m-1 && c == n-1) return true;
26            for(int[] move : dir[grid[r][c]]){
27                int nr = r + move[0];
28                int nc = c + move[1];
29
30                if(nr <0 || nc<0 || nr>=m || nc>=n || visit[nr][nc]) continue;
31
32                for(int[] back : dir[grid[nr][nc]]){
33                    if(nr + back[0] == r && nc + back[1] == c){
34                        visit[nr][nc] = true;
35                        queue.offer(new int[]{nr, nc});
36                    }
37                }
38            }
39        }
40        return false;
41    }
42}