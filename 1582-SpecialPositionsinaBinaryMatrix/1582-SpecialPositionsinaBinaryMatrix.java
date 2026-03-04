// Last updated: 3/4/2026, 1:14:40 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] rC = new int[m];
7        int[] cC = new int[n];
8
9        for(int i=0;i<m;i++){
10            for(int j=0;j<n;j++){
11                if(mat[i][j] != 1) continue;
12                rC[i]++;
13                cC[j]++;
14            }
15        }
16        int count=0;
17        for(int i=0;i<m;i++){
18            for(int j=0;j<n;j++){
19                if((mat[i][j] == 1) && (rC[i] == 1) && (cC[j] == 1)){
20                    count++;
21                }
22            }
23        }
24        return count;
25    }
26}