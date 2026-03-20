// Last updated: 3/20/2026, 9:38:41 AM
1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] ans = new int[m-k+1][n-k+1];
7         for (int i = 0; i <= m - k; i++) {
8            for (int j = 0; j <= n - k; j++) {
9                List<Integer> v = new ArrayList<>();
10                for (int x = i; x < i + k; x++)
11                    for (int y = j; y < j + k; y++)
12                        v.add(grid[x][y]);
13                        Collections.sort(v);
14                        int mn = Integer.MAX_VALUE;
15                        int prev = v.get(0);    
16                            for (int p = 1; p < v.size(); p++) {
17                                if (v.get(p) != prev)
18                                    mn = Math.min(mn, v.get(p) - prev);
19                                prev = v.get(p);
20                            }
21                        ans[i][j] = (mn == Integer.MAX_VALUE) ? 0 : mn;
22                    }
23                }
24            return ans;
25        
26    }
27}