// Last updated: 7/3/2026, 1:22:37 PM
1class Tuple {
2    int x, y, h; 
3    Tuple(int i, int j, int h) {
4        this.x = i; 
5        this.y = j; 
6        this.h = h; 
7    }
8}
9
10class Solution {
11    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
12        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.h - a.h); 
13
14        pq.offer(new Tuple(0, 0, health - grid.get(0).get(0))); 
15
16        int[][] dirs = {
17            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
18        }; 
19        int m = grid.size(); 
20        int n = grid.get(0).size(); 
21        int rh[][] = new int[m][n]; // running health 
22        rh[0][0] = health - grid.get(0).get(0); 
23
24        // for(int i = 0; i < m; i++) Arrays.fill(rh[i], -1); 
25
26        while(pq.size() > 0) {
27            Tuple cur = pq.remove(); // returns andn remove top elemenet  
28            if(cur.x == m - 1 && cur.y == n - 1 ) return rh[m -1][n -1] > 0; 
29
30            for(int d[]: dirs) {
31                int nx = cur.x + d[0], ny = cur.y + d[1], nh = rh[cur.x][cur.y]; 
32                if(nx >= 0 && ny >= 0 && nx < m && ny < n && rh[nx][ny] < nh - grid.get(nx).get(ny)) {
33                    pq.offer(new Tuple(nx, ny, nh - grid.get(nx).get(ny)));
34                    rh[nx][ny] = nh - grid.get(nx).get(ny); 
35                }
36            }
37        }
38
39        return false; 
40    }
41}