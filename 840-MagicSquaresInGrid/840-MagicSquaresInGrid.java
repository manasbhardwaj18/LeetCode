// Last updated: 12/30/2025, 1:32:58 PM
1class Solution {
2    public int numMagicSquaresInside(int[][] grid) {
3        int row = grid.length , col = grid[0].length, res = 0;
4        if(row < 3 || col < 3){
5            return 0;
6        }
7
8        for(int i=0; i+2 < row ; i++ ){
9            for(int j=0; j+2 < col; j++){
10                boolean[] reach = new boolean[10];
11                boolean yup = true;
12
13                for(int x=0; x < 3 && yup; x++){
14                    for(int y=0; y <3;y++){
15                        int v = grid[i+x][j+y];
16                        if(v < 1 || v>9 || reach[v]){
17                            yup = false;
18                            break;
19                        }
20                        reach[v] = true;
21                    }
22                }
23                if(!yup){
24                    continue;
25                }
26
27                int sum = grid[i][j] + grid[i][j+1] +  grid[i][j+2];
28                for(int m=0;m<3;m++){
29                    if(grid[i+m][j] + grid[i+m][j+1] +  grid[i+m][j+2] != sum) yup = false;
30                }
31                for(int n=0;n<3;n++){
32                    if(grid[i][j+n] + grid[i+1][j+n] +  grid[2+i][j+n] != sum) yup = false;
33                }
34                if(grid[i][j] + grid[i+1][j+1] +  grid[i+2][j+2] != sum) yup = false;
35                if(grid[i][j+2] + grid[i+1][j+1] +  grid[i+2][j] != sum) yup = false;
36
37                if(yup){
38                    res ++;
39                }
40
41            }
42        }
43        return res;
44    }
45}