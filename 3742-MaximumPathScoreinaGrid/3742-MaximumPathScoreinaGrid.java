// Last updated: 4/30/2026, 11:56:09 PM
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][][] dp = new int[m][n][k+1];
7
8        for(int i=0; i<m; i++){
9            for(int j=0; j<n; j++){
10                for(int c=0; c <= k; c++){
11                    dp[i][j][c] = -1;
12                }
13            }
14        }
15
16        dp[0][0][0]  = 0;
17        for(int i=0; i<m; i++){
18            for(int j=0; j<n; j++){
19                for(int c=0; c<=k; c++){
20                    if(dp[i][j][c] == -1) continue;
21
22                    if(i+1 < m){
23                        int val = grid[i+1][j];
24                        int cost = (val == 0 ? 0 : 1);
25
26                        int nc = c + cost;
27                        if(nc <= k){
28                            dp[i+1][j][nc] = Math.max(dp[i+1][j][nc], dp[i][j][c] + val);
29                        }
30                    }
31
32                    if(j + 1 < n){
33                        int val = grid[i][j+1];
34                        int cost = (val == 0 ? 0 : 1);
35                        int nc = c + cost;
36                        if( nc <= k){
37                            dp[i][j+1][nc] = Math.max(dp[i][j+1][nc], dp[i][j][c] + val);
38                        }
39                    }
40                }
41            }
42        }
43    
44        int ans = -1;
45        for(int c = 0; c <= k; c++){
46            ans = Math.max(ans, dp[m-1][n-1][c]);
47        }
48        return ans;
49    }
50}