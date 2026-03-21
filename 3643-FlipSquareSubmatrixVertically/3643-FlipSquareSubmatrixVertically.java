// Last updated: 3/22/2026, 1:02:32 AM
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        int a = y;
4        int b = y+k-1;
5        int c = x;
6
7        for(int j=a; j<= b; j++){
8            for(int i=0; i<k/2; i++){
9                int temp = grid[c+i][j];
10                grid[c+i][j] = grid[c+k-i-1][j];
11                grid[c+k-i-1][j] = temp;
12            }
13        }
14        return grid;
15    }
16}