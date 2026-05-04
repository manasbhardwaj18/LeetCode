// Last updated: 5/4/2026, 2:47:07 PM
1class Solution {
2    public void rotate(int[][] matrix) {
3        int edgeLength = matrix.length;
4
5        int top = 0;
6        int bottom = edgeLength - 1;
7
8        while (top < bottom) {
9            for (int col = 0; col < edgeLength; col++) {
10                int temp = matrix[top][col];
11                matrix[top][col] = matrix[bottom][col];
12                matrix[bottom][col] = temp;
13            }
14            top++;
15            bottom--;
16        }
17
18        for (int row = 0; row < edgeLength; row++) {
19            for (int col = row + 1; col < edgeLength; col++) {
20                int temp = matrix[row][col];
21                matrix[row][col] = matrix[col][row];
22                matrix[col][row] = temp;
23            }
24        }        
25    }
26}