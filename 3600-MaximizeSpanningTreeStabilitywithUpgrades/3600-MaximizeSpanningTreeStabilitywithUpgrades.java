// Last updated: 3/12/2026, 3:10:36 PM
1class Solution {
2    int comp;
3    int[] parent;
4    int[] sz;
5
6    int findParent(int node){
7        if(parent[node] == node) return node;
8        return parent[node] = findParent(parent[node]);
9    }
10
11    boolean union(int u, int v){
12        int pu = findParent(u);
13        int pv = findParent(v);
14        if(pu == pv) return false;
15        comp--;
16
17        if(sz[pu] > sz[pv]){
18            parent[pv] = pu;
19            sz[pu] += sz[pv];
20        }else{
21            parent[pu] = pv;
22            sz[pv] += sz[pu];
23        }
24        return true;
25    }
26
27    public int maxStability(int n, int[][] edges, int k) {
28        comp = n;
29        parent = new int[n];
30        sz = new int[n];
31
32        for(int i=0; i<n; i++){
33            parent[i] = i;
34            sz[i] = 1;
35        }
36
37        List<int[]> a = new ArrayList<>();
38        List<int[]> b = new ArrayList<>();
39
40        for(int[] e : edges){
41            if(e[3] == 1) a.add(e);
42            else b.add(e);
43        }
44
45        int mini = Integer.MAX_VALUE;
46
47        for(int[] e : a){
48            int u = e[0];
49            int v = e[1];
50            int w = e[2];
51
52            mini = Math.min(mini, w);
53            if(!union(u,v)) return -1;
54        }
55
56        b.sort((a1,b1) -> b1[2] - a1[2]);
57
58        PriorityQueue<Integer> pq = new PriorityQueue<>();
59        for(int[] e : b){
60            int u = e[0];
61            int v = e[1];
62            int w = e[2];
63
64            if(union(u,v)){
65                pq.add(w);
66            }
67        }
68
69        while(k-- > 0 && !pq.isEmpty()){
70            int x = pq.poll();
71            mini = Math.min(mini, 2*x);
72        }
73        if(comp != 1) return -1;
74        if(!pq.isEmpty()){
75            return Math.min(mini, pq.peek());
76        }
77        return mini;
78    }
79}