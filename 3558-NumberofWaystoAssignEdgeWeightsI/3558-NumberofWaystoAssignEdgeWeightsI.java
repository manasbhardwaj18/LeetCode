// Last updated: 6/12/2026, 12:43:56 AM
1class Solution {
2    private static final int mod = 1000000007;
3    public int assignEdgeWeights(int[][] edges) {
4        int n = edges.length + 1;
5        List<Integer>[] graph = new ArrayList[n+1];
6        Arrays.setAll(graph, i -> new ArrayList<>());
7
8        for(int[] e : edges){
9            graph[e[0]].add(e[1]);
10            graph[e[1]].add(e[0]);
11        }
12        return (int) pow(2, dfs(1, 0, graph) - 1);
13    }
14    private int dfs(int node, int prev, List<Integer>[] graph){
15        int dist = 0;
16        for(int g : graph[node]){
17            if(g != prev ){
18                dist = Math.max(dist, dfs(g, node, graph) + 1);
19            }
20        }
21        return dist;
22    }
23
24    private long pow(long base, int exp){
25        long res = 1;
26        while(exp > 0){
27            if(exp % 2 > 0){
28                res = res*base % mod;
29            }
30            base = base*base % mod;
31            exp /= 2;
32        }
33        return res;
34    }
35}
36