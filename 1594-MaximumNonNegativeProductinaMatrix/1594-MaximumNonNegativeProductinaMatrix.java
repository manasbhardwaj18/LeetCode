// Last updated: 3/23/2026, 11:40:42 AM
1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long mod = 1000000007;
5
6        long[][] maxP = new long[m][n];
7        long[][] minP = new long[m][n];
8
9        maxP[0][0] = minP[0][0] = grid[0][0];
10
11        for(int i=1; i<m; i++){
12            maxP[i][0] = minP[i][0] = maxP[i-1][0]*grid[i][0];
13        }
14
15        for(int j=1; j<n; j++){
16            maxP[0][j] = minP[0][j] = maxP[0][j-1]* grid[0][j]; 
17        }
18
19        for(int i=1; i<m; i++){
20            for(int j=1; j<n; j++){
21                long val = grid[i][j];
22
23                long a = maxP[i-1][j]*val;
24                long b = minP[i-1][j]*val;
25                long c = maxP[i][j-1]*val;
26                long d = minP[i][j-1]*val;
27
28                maxP[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
29                minP[i][j] = Math.min(Math.min(a,b), Math.min(c,d));
30            }
31        }
32
33        long res = maxP[m-1][n-1];
34        if(res < 0){
35            return -1;
36        }
37        return (int)(res % mod);
38
39    }
40}