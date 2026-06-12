// Last updated: 6/12/2026, 6:55:22 PM
1class Solution {
2    static final int MOD = 1000000007;
3    int one;
4    int[][] level;
5    int[] depth;
6    List<Integer>[] adj;
7
8    long modPow(long a, long b){
9        long ans = 1;
10        while(b > 0){
11            if((b & 1) == 1){
12                ans = (ans * a) % MOD;
13            }
14            a = (a*a) % MOD;
15            b >>= 1;
16        }
17        return ans;
18    } 
19
20    void dfs(int node, int parent){
21        level[node][0] = parent;
22        for(int j = 1; j < one; j++){
23            level[node][j] = level[level[node][j-1]][j-1];
24        }
25        for(int next : adj[node]){
26            if(next == parent) continue;
27            depth[next] = depth[node] + 1;
28            dfs(next, node);
29        }
30    }
31
32    int lca(int u, int v){
33        if(depth[u] < depth[v]){
34            int temp = u;
35            u = v;
36            v = temp;
37        }
38        int diff = depth[u] - depth[v];
39        for(int j = one-1; j >= 0; j--){
40            if((diff & (1 << j)) != 0){
41                u = level[u][j];
42            }
43        }
44
45        if( u == v) return u;
46
47        for(int j = one-1; j >=0; j--){
48            if(level[u][j] != level[v][j]){
49                u = level[u][j];
50                v = level[v][j];
51            }
52        }
53        return level[u][0];
54    }
55    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
56        int n = edges.length + 1;
57        one = 1;
58        while((1 << one) <= n) one++;
59        adj = new ArrayList[n+1];
60        
61        for(int i=0; i<=n; i++){
62            adj[i]= new ArrayList<>();
63        }
64
65        for(int[] edge : edges){
66            int u = edge[0];
67            int v = edge[1];
68
69            adj[u].add(v);
70            adj[v].add(u);
71        }
72        depth = new int[n+1];
73        level = new int[n+1][one];
74        dfs(1,0);
75
76        int[] ans = new int[queries.length];
77
78        for(int i=0; i < queries.length; i++){
79            int u = queries[i][0];
80            int v = queries[i][1];
81
82            int L = lca(u, v);
83            long dist = depth[u] + depth[v] - 2L * depth[L];
84
85            if(dist == 0){
86                ans[i] = 0;
87            }else{
88                ans[i] = (int) modPow(2, dist-1);
89            }
90        }
91        return ans;
92    }
93}