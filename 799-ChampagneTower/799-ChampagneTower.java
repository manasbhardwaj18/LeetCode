// Last updated: 2/14/2026, 1:51:58 PM
1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        double[][] tower = new double[102][102];
4        tower[0][0] = (double) poured;
5
6        for(int row = 0; row <= query_row ; row++){
7            for(int col = 0; col <= row; col++){
8                if(tower[row][col] > 1.0){
9                    double excess = (tower[row][col] - 1.0) / 2.0; //splitting
10                    tower[row][col] = 1.0;
11                    tower[row+1][col] += excess;
12                    tower[row+1][col+1] += excess; 
13                }
14            }
15        }
16        return tower[query_row][query_glass];
17    }
18}