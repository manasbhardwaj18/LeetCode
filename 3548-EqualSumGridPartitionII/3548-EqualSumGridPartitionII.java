// Last updated: 3/26/2026, 2:26:46 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        long total = 0;
4        int m = grid.length, n = grid[0].length;
5        for(int i=0; i<m; i++){
6            for(int j=0;j<n;j++){
7                total += grid[i][j];
8            }
9        }
10
11        for(int k=0; k<4; k++){
12            Set<Long> set = new HashSet<>();
13            set.add(0L);
14            long sum=0;
15            m = grid.length;
16            n=grid[0].length;
17            if(m<2){
18                grid = rotation(grid);
19                continue;
20            }
21            if(n == 1){
22                for(int i=0;i<m-1;i++){
23                    sum+= grid[i][0];
24                    long tag = sum*2- total;
25                    if(tag == 0 || tag==grid[0][0] || tag==grid[i][0]){
26                        return true;
27                    }
28                }
29                grid=rotation(grid);
30                continue;
31            }
32            for(int i=0;i<m-1;i++){
33                for(int j=0; j<n; j++){
34                    set.add((long)grid[i][j]);
35                    sum += grid[i][j];
36                }
37                long tag = sum*2 - total;
38                if(i==0){
39                    if(tag==0 || tag==grid[0][0] || tag ==grid[0][n-1]){
40                        return true;
41                    }
42                    continue;
43                }
44                if(set.contains(tag)){
45                    return true;
46                }
47            }
48            grid = rotation(grid);
49        }
50        return false;
51    }
52
53    public int[][] rotation(int[][] grid){
54        int m= grid.length, n = grid[0].length;
55        int[][] arr = new int[n][m];
56        for(int i=0;i<m;i++){
57            for(int j=0; j<n; j++){
58                arr[j][m-1-i] = grid[i][j];
59            }
60        }
61        return arr;
62    }
63}