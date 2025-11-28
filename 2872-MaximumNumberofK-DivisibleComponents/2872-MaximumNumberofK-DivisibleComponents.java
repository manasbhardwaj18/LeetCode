// Last updated: 11/28/2025, 7:00:15 AM
1class Solution {
2    private Map<Integer, List<Integer>> adj;
3    private Set<Integer> visited;
4    private int comp;
5
6    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
7        adj = new HashMap<>();
8        visited = new HashSet<>();
9        comp=0;
10
11        int src = 0;
12
13        for(int[] edge : edges){
14            int u = edge[0];
15            int v = edge[1];
16            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
17            adj.computeIfAbsent(v, k1 -> new ArrayList<>()).add(u);
18        }
19        dfs(src, values, k);
20        return comp;
21    }
22
23    private int dfs(int root, int[] values, int k){
24        if(visited.contains(root)){
25            return 0;
26        }
27        visited.add(root);
28        int ans = values[root];
29
30        for(int neight : adj.getOrDefault(root, Collections.emptyList())){
31            ans += dfs(neight, values, k);
32        }
33        if(ans % k == 0){
34            comp++;
35            return 0;
36        }
37        return ans % k;
38    }
39}