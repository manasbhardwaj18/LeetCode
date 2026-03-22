// Last updated: 3/22/2026, 9:53:52 AM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        for(int i=0; i<4; i++){
4            if(isEqual(mat, target)) return true;
5            rotate(mat);
6        }
7        return false;
8    }
9
10    private void rotate(int[][] mat){
11        int n = mat.length;
12        for(int i=0; i<n; i++){
13            for(int j=i+1; j<n; j++){
14                int temp = mat[i][j];
15                mat[i][j] = mat[j][i];
16                mat[j][i] = temp;
17            }
18        }
19
20        for(int i=0;i<n;i++){
21            for(int j=0; j<n/2; j++){
22                int temp = mat[i][j];
23                mat[i][j] = mat[i][n-1-j];
24                mat[i][n-1-j] = temp;
25            }
26        }
27    }
28
29    private boolean isEqual(int[][] mat, int[][] target){
30        for(int i=0; i<mat.length; i++){
31            for(int j=0; j<mat[0].length; j++){
32                if(mat[i][j] != target[i][j]) return false;
33            }
34        }
35            return true;
36    }
37    
38}