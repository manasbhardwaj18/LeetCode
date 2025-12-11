// Last updated: 12/11/2025, 2:03:41 PM
1class Solution {
2    public int countCoveredBuildings(int n, int[][] buildings) {
3        Map<Integer, int[]> x_y = new HashMap<>();
4        Map<Integer, int[]> y_x = new HashMap<>();
5
6        for(int[] point : buildings){
7            int x = point[0];
8            int y = point[1];
9
10            x_y.putIfAbsent(x, new int[]{y, y});
11
12            int[] y_range = x_y.get(x);
13            y_range[0] = Math.min(y_range[0], y);
14            y_range[1] = Math.max(y_range[1], y);
15
16            y_x.putIfAbsent(y, new int[]{x, x});
17
18            int[] x_range = y_x.get(y);
19            x_range[0] = Math.min(x_range[0], x);
20            x_range[1] = Math.max(x_range[1], x); 
21        }
22
23        int cover = 0;
24        for(int[] point : buildings){
25            int x = point[0];
26            int y = point[1];
27            int[] y_range = x_y.get(x);
28            int[] x_range = y_x.get(y);
29
30            if(x < x_range[1] && x > x_range[0] && y < y_range[1] && y > y_range[0]){
31                cover++;
32            }
33        }
34        return cover;
35    }
36}