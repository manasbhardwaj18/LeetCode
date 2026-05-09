// Last updated: 5/9/2026, 2:44:21 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int layer = Math.min(m,n)/2;
5
6        for(int l=0; l < layer; l++){
7            List<Integer> val = new ArrayList<>();
8            int top = l, left = l;
9            int bottom= m - l - 1, right = n - l - 1;
10
11            //top
12            for(int j = left; j < right; j++){
13                val.add(grid[top][j]);
14            }
15            // right
16            for(int i = top; i < bottom; i++){
17                val.add(grid[i][right]);
18            }
19            // bottom
20            for(int j = right; j > left; j--){
21                val.add(grid[bottom][j]);
22            }
23            //left
24            for(int i = bottom; i > top; i--){
25                val.add(grid[i][left]);
26            }
27
28            int len = val.size();
29            int shift = k % len;
30            Collections.rotate(val, -shift);
31
32            int idx = 0;
33
34            //put back
35            for(int j = left; j < right; j++) grid[top][j] = val.get(idx++);
36            for(int i = top; i < bottom; i++) grid[i][right] = val.get(idx++);
37            for(int j = right; j > left; j--) grid[bottom][j] = val.get(idx++);
38            for(int i = bottom; i > top; i--) grid[i][left] = val.get(idx++);
39        }
40        return grid;
41    }
42}