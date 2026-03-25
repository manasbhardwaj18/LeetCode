// Last updated: 3/25/2026, 8:31:28 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long total = 0;
5
6        for(int[] row : grid){
7            for(int x : row){
8                total += x;
9            }
10        }
11
12        if((total & 1) == 1) return false;
13
14        long target = total/2;
15        long sum = 0;
16
17        for(int i=0; i<m-1; i++){
18            for(int j=0; j<n; j++){
19                sum += grid[i][j];
20            }
21            if(sum == target) return true;
22        }
23        sum = 0;
24
25        for(int j=0; j<n-1; j++){
26            for(int i=0; i<m; i++){
27                sum += grid[i][j];
28            }
29            if(sum == target) return true;
30        }
31        return false;
32    }
33}