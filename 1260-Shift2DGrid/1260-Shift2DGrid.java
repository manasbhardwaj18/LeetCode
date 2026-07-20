// Last updated: 7/20/2026, 10:45:46 PM
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int total = m*n;
7        k %= total;
8
9        List<List<Integer>> res = new ArrayList<>();
10        for(int i=0; i<m; i++){
11            List<Integer> row = new ArrayList<>();
12            for(int j=0; j<n; j++){
13                row.add(0);
14            }
15            res.add(row);
16        }
17
18        for(int i=0; i < m; i++){
19            for( int j=0; j < n; j++){
20                int oldIdx = i*n+j;
21                int newIdx = (oldIdx + k) % total;
22                int newRow = newIdx / n;
23                int newCol = newIdx % n;
24
25                res.get(newRow).set(newCol, grid[i][j]);  
26            }
27        }
28        return res;
29    }
30}