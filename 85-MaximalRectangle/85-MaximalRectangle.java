// Last updated: 1/11/2026, 1:07:34 PM
1public class Solution {
2
3    public int largestRectangleArea(int[] heights) {
4        Stack<Integer> stack = new Stack<>();
5        int maxArea = 0;
6        int n = heights.length;
7        for (int i = 0; i <= n; i++) {
8            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
9                int height = heights[stack.pop()];
10                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
11                maxArea = Math.max(maxArea, width * height);
12            }
13            stack.push(i);
14        }
15        return maxArea;
16    }
17
18    public int maximalAreaOfSubMatrixOfAll1(char[][] matrix, int n, int m) {
19        int maxArea = 0;
20        int[] height = new int[m];
21        for (int i = 0; i < n; i++) {
22            for (int j = 0; j < m; j++) {
23                if (matrix[i][j] == '1') {
24                    height[j]++;
25                } else {
26                    height[j] = 0;
27                }
28            }
29            int area = largestRectangleArea(height);
30            maxArea = Math.max(maxArea, area);
31        }
32        return maxArea;
33    }
34
35    public int maximalRectangle(char[][] matrix) {
36        return maximalAreaOfSubMatrixOfAll1(matrix, matrix.length, matrix[0].length);
37    }
38}