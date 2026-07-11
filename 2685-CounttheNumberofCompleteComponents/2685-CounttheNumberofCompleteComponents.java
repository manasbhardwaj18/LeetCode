// Last updated: 7/11/2026, 10:15:10 PM
1class Solution {
2    static int V, D;
3
4    public int countCompleteComponents(int n, int[][] edges) {
5        List<Integer>[] A = new ArrayList[n];
6        Arrays.setAll(A, _ -> new ArrayList<>());
7
8        for (int[] e : edges) {
9            A[e[0]].add(e[1]);
10            A[e[1]].add(e[0]);
11        }
12
13        boolean[] vis = new boolean[n];
14        int res = 0;
15
16        for (int i = 0; i < n; i++) {
17            boolean state = vis[i];
18
19            if (!state) {
20                V = 0; D = 0;
21
22                dfs(i, A, vis);
23
24                if (D == V * (V - 1)) res++;
25            }
26        }
27
28        return res;
29    }
30
31    private void dfs(int x, List<Integer>[] A, boolean[] vis) {
32        V++;
33        D += A[x].size();
34        vis[x] = true;
35
36        for (int state : A[x])
37            if (!vis[state])
38                dfs(state, A, vis);
39    }
40}
41