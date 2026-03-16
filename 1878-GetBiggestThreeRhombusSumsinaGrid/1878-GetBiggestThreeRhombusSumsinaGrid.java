// Last updated: 3/16/2026, 1:53:07 PM
1class Solution {
2    int m;
3    int n;
4    public int[] getBiggestThree(int[][] grid) {
5        m = grid.length;
6        n = grid[0].length;
7        int max = (Math.min(m, n)+1)/2;
8        TreeSet<Integer> t1 = new TreeSet<>();
9        for (int i = 0; i < m; i++){
10            for (int j = 0; j < n; j++){
11                for (int edge = 0; edge <= max; edge++){
12                    int sum = getSum(grid, i, j, edge);
13                    if (sum != 0) t1.add(sum);
14                    if (t1.size() > 3) t1.pollFirst();
15                }
16            }
17        }
18        
19        int[] ans = new int[t1.size()];
20        int index = t1.size()-1;
21        for (int i : t1){
22            ans[index--] = i;
23        }
24        return ans;
25    }
26    
27    private int getSum(int[][] grid, int i,int j,int edge){
28        if (edge == 0) return grid[i][j];
29        if (i+2*edge>=m || j-edge<0 || j+edge>=n) return 0;
30        int sum = 0;        
31        for (int k = 0; k < edge; k++){
32            sum += grid[i+k][j+k] + grid[i+edge+k][j+edge-k] + grid[i+2*edge-k][j-k]+grid[i+edge-k][j-edge+k];            
33        }
34        return sum;
35    }
36}
37