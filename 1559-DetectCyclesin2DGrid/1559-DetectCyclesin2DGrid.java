// Last updated: 4/26/2026, 3:42:35 PM
1class Solution {
2    static int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
3    public boolean containsCycle(char[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6        boolean[] visit= new boolean[m*n];
7
8        for(int i=0; i<m; i++){
9            for(int j=0; j<n; j++){
10                if(!visit[i*n + j] && dfs(i, j, -1, -1, grid, visit, m, n)) return true;
11            }
12        }
13        return false;
14    }
15
16    private static boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[] visit, int m, int n){
17        visit[r*n + c] = true;
18
19        for(int k=0; k<4; k++){
20            int nr = r + dirs[k][0];
21            int nc = c + dirs[k][1];
22            if ((nr != pr || nc != pc) &&
23                    nr >= 0 && nr < m && nc >= 0 &&
24                    nc < n && grid[nr][nc] == grid[r][c])
25                if(visit[nr*n + nc] || dfs(nr, nc, r, c, grid, visit, m, n)) return true;
26                
27            }
28        return false;
29    }
30}