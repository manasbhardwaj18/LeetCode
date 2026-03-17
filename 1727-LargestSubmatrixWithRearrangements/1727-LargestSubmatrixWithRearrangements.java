// Last updated: 3/17/2026, 1:45:52 PM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int max = 0;
6        int[] h = new int[n];
7
8        for(int i=0; i<m; i++){
9            for(int j=0; j<n; j++){
10                if(matrix[i][j] == 1){
11                    h[j]++;
12                }else{
13                    h[j] = 0;
14                }
15            }
16
17            int[] sec = h.clone();
18            Arrays.sort(sec);
19            for(int j=n-1; j>=0; j--){
20                if(sec[j] == 0) break;
21                max = Math.max(max, sec[j]*(n-j));
22            }
23        }
24        return max;
25    }
26}