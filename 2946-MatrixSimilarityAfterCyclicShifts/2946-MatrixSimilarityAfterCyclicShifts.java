// Last updated: 3/27/2026, 11:36:36 AM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length, n = mat[0].length;
4        int shift = k % n;
5
6        for(int i=0; i<m; i++){
7            for(int j=0; j<n; j++){
8                if(i%2 == 0){
9                    if(mat[i][j] != mat[i][(j+shift)%n]) return false;
10                }else{
11                    if(mat[i][j] != mat[i][(j+n-shift)%n]) return false;                    
12                }
13            }
14        }
15        return true;
16    }
17}