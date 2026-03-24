// Last updated: 3/24/2026, 11:51:55 AM
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        final int mod = 12345;
4        int m =grid.length,  n= grid[0].length;
5        int[][] p = new int[m][n];
6
7        long suf = 1;
8
9        for(int i=m-1; i>=0; i--){
10            for(int j=n-1; j>=0; j--){
11                p[i][j] = (int) suf;
12                suf = (suf*grid[i][j]) % mod;
13            }
14        }
15
16        long pre = 1;
17
18        for(int i=0; i<m; i++){
19            for(int j=0; j<n; j++){
20                p[i][j] = (int)(((long) p[i][j] * pre) % mod);
21                pre = (pre*grid[i][j])%mod;
22            }                                           
23        }
24        return p;
25
26    }
27}