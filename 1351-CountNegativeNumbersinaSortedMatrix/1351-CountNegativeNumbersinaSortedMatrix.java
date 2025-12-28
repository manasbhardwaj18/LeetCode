// Last updated: 12/28/2025, 1:38:47 PM
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int count=0;
4        for(int i=0;i<grid.length;i++){
5            for(int j=0;j<grid[i].length;j++){
6                if(grid[i][j] < 0){
7                    count += grid[i].length - j;
8                    break;
9                }
10            }
11        }
12        return count;
13    }
14}