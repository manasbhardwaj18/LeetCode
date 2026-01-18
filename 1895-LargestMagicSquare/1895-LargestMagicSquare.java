// Last updated: 1/18/2026, 1:19:40 PM
1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] row = new int[m][n+1];
7        int[][] col = new int[m+1][n];
8
9        for(int i=0;i <m; i++){
10            for(int j=0; j<n; j++){
11                row[i][j+1] = row[i][j] + grid[i][j];
12                col[i+1][j] = col[i][j] + grid[i][j];
13            }
14        }
15
16        for(int k = Math.min(m,n); k>=2; k--){
17            for(int i=0; i +k <= m; i++){
18                for(int j=0; j+k <= n; j++){
19
20                    int exp = row[i][j+k] - row[i][j];
21                    boolean fin = true;
22
23                    for(int z = i; z < i+k && fin; z++){
24                        if(row[z][j+k] - row[z][j] != exp){
25                            fin = false;
26                        }
27                    }
28
29                    for(int y = j; y<j+k && fin; y++){
30                        if(col[i+k][y] - col[i][y] != exp){
31                            fin = false;
32                        }
33                    }
34
35                    int p1=0, p2 = 0;
36                    for(int x = 0; x<k; x++){
37                        p1 += grid[i+x][j+x];
38                        p2 += grid[i+x][j+k-(1+x)];
39                    }
40                    if((fin && p1 == exp) && (p2 ==exp)){
41                        return k;
42                    }
43                }
44            }
45
46        }
47        return 1;
48    }
49}