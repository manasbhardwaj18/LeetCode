// Last updated: 4/29/2026, 12:14:06 PM
1class Solution {
2    public long maximumScore(int[][] grid) {
3        int n = grid.length;
4        if(n==1) return 0;
5        long[] dp0 = new long[n+1];
6        long[] dp1 = new long[n+1];
7
8        for(int j=1; j<n; j++){
9            long[] new_dp0 = new long[n+1];
10            long[] new_dp1 = new long[n+1];
11
12            for(int i=0; i<=n; i++){
13                long prev = 0, curr = 0;
14                for(int x = 0; x < i; x++) curr += grid[x][j];
15                for(int y = 0; y <= n; y++){
16                    if(y > 0 && y <= i){
17                        curr -= grid[y-1][j];
18                    }
19                    if(y > i){
20                        prev += grid[y-1][j-1];
21                    }
22                    new_dp0[y] = Math.max(new_dp0[y], Math.max(prev + dp0[i], dp1[i]));
23                    new_dp1[y] = Math.max(new_dp1[y], Math.max(curr + dp1[i], curr + prev + dp0[i]));
24                }
25            }
26            dp0 = new_dp0;
27            dp1 = new_dp1;
28        }
29        long res = 0;
30        for(long v : dp1){
31            res = Math.max(res, v);
32        }
33        return res;
34    }
35}