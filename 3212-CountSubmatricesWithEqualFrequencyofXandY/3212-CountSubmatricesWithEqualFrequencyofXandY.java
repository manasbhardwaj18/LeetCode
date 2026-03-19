// Last updated: 3/19/2026, 9:43:55 AM
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        int[][] sum = new int[n][m];
7        int[][] cnt = new int[n][m];
8
9        int res = 0;
10
11        for(int i=0; i<n; i++){
12            for(int j=0; j<m;j++){
13                int val = 0, x = 0;
14                if(grid[i][j] == 'X'){
15                    val = 1;
16                    x = 1;
17                }else if(grid[i][j] == 'Y'){
18                    val = -1;
19                }
20                sum[i][j] = val;
21                cnt[i][j] = x;
22
23                if(i>0){
24                    sum[i][j] += sum[i-1][j];
25                    cnt[i][j] += cnt[i-1][j];
26                }
27                if(j > 0){
28                    sum[i][j] += sum[i][j-1];
29                    cnt[i][j] += cnt[i][j-1];
30                }
31                if(i>0 && j>0){
32                    sum[i][j] -= sum[i-1][j-1];
33                    cnt[i][j] -= cnt[i-1][j-1];
34                }
35                if(sum[i][j] == 0 && cnt[i][j] > 0){
36                    res++;
37                }
38            }
39        }
40        return res;
41    }    
42}