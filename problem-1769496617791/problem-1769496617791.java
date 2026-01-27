// Last updated: 1/27/2026, 12:20:17 PM
1class Solution {
2    public int minCost(int n, int[][] edges) {
3        List<List<int[]>> out = new ArrayList<>();
4        List<List<int[]>> in = new ArrayList<>();
5
6        for(int i=0;i<n;i++){
7            out.add(new ArrayList<>());
8            in.add(new ArrayList<>());
9        }
10
11        for(int[] e: edges){
12            out.get(e[0]).add(new int[]{e[1],e[2]});
13            in.get(e[1]).add(new int[]{e[0],e[2]});
14        }
15
16        long inf = (long) 1e18;
17        long dist[][] = new long[n][2];
18        for(int i=0; i <n;i++){
19            Arrays.fill(dist[i],inf);
20        }
21
22        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
23        dist[0][0] = 0;
24        pq.add(new long[]{0,0,0});  // three characteristics
25
26        while(!pq.isEmpty()){
27            long[] now = pq.poll();
28            long val = now[0];
29            int m = (int) now[1];
30            int u = (int) now[2];
31            
32            if(val > dist[m][u]){
33                continue;
34            }
35
36            for(int[] edge : out.get(m)){
37                int a = edge[0];
38                int b = edge[1];
39
40                if(dist[a][0] > val + b){
41                    dist[a][0] = val + b;
42                    pq.add(new long[]{dist[a][0],a,0});
43                }
44            }
45
46            if(u == 0){
47                for(int[] edge : in.get(m)){
48                    int a = edge[0];
49                    int b = edge[1];
50                    if(dist[a][0] > val + 2L*b){
51                        dist[a][0] = val + 2L*b;
52                        pq.add(new long[]{dist[a][0],a,0});
53                    }   
54                }
55            }
56        }
57
58        long res = Math.min(dist[n-1][0], dist[n-1][1]);
59        return res >= inf ? -1: (int) res;
60    }
61}