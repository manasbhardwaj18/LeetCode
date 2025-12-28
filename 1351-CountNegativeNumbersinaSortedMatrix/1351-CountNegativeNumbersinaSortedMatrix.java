// Last updated: 12/28/2025, 1:37:34 PM
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int count=0;
4        for(int i=0;i<grid.length;i++){
5            for(int j=0;j<grid[i].length;j++){
6                if(grid[i][j] < 0){
7                    count++;
8                }
9            }
10        }
11        return count;
12    }
13}