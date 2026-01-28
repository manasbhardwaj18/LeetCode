// Last updated: 1/28/2026, 2:54:29 PM
1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        final long inf = (long) 4e18;
6        long[][] dp = new long[m][n];
7
8        for(int i=0; i<m; i++){
9            Arrays.fill(dp[i], inf);
10        }
11
12        dp[0][0] = 0;
13        for(int i=0; i <m; i++){
14            for(int j=0;j<n;j++){
15                if(i>0){
16                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + grid[i][j]);
17                }
18                if(j>0){
19                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + grid[i][j]);
20                }
21            }
22        }
23
24        ArrayList<int[]>cells = new ArrayList<>();
25        for(int i=0; i<m;i++){
26            for(int j=0; j<n; j++){
27                cells.add(new int[]{grid[i][j], i, j});
28            }
29        }
30        cells.sort((a,b)-> Integer.compare(b[0], a[0]));
31
32        for(int step = 0; step<k; step++){
33            long[][] start = new long[m][n];
34            for(int i=0; i<m;i++){
35                Arrays.fill(start[i], inf);
36            }
37
38            long runMin = inf;
39            int id = 0;
40            while(id < cells.size()){
41                int val = cells.get(id)[0];
42                int j = id;
43                long minGroup = inf;
44
45                while(j<cells.size() && cells.get(j)[0] == val){
46                    int x = cells.get(j)[1], y = cells.get(j)[2];
47                    minGroup = Math.min(minGroup, dp[x][y]);
48                    j++;
49                }
50                runMin = Math.min(runMin,minGroup);
51                for(int p=id; p<j;p++){
52                    int x = cells.get(p)[1], y = cells.get(p)[2];
53                    start[x][y] = Math.min(dp[x][y],runMin);
54                }
55                id = j;
56            }
57
58            long[][] dp2 = new long[m][n];
59            for(int i =0;i<m;i++){
60                Arrays.fill(dp2[i], inf);
61            }
62            for(int i=0; i<m;i++){
63                for(int j=0;j<n;j++){
64                    if(start[i][j] < dp2[i][j]){
65                        dp2[i][j] = start[i][j];
66                    }
67                    if(i+1 < m && dp2[i][j] < inf){
68                        dp2[i+1][j] = Math.min(dp2[i+1][j], dp2[i][j] + grid[i+1][j]);
69                    }
70                    if(j+1 < n && dp2[i][j] < inf){
71                        dp2[i][j+1] = Math.min(dp2[i][j+1], dp2[i][j] + grid[i][j+1]);
72                    }
73                }
74            }
75            dp = dp2;
76        }
77        return (int) dp[m-1][n-1];
78    }
79}