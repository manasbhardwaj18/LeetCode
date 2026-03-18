// Last updated: 3/18/2026, 2:30:05 PM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        int[] sum = new int[m];
7        int res=0;
8
9        for(int i=0;i<n;i++){
10            int rSum = 0;
11            for(int j=0;j<m;j++){
12                rSum += grid[i][j];
13                sum[j] += rSum;
14
15                if(sum[j] <= k){
16                    res++;
17                }
18            }
19        } 
20        return res;
21    }
22}