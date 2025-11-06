// Last updated: 11/6/2025, 4:33:22 PM
class Solution {
    HashMap<Integer, List<Integer>> graph;
    int[] mapping;
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        graph = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] connection : connections) {
            int src = connection[0];
            int dest = connection[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        int curr = 1; 
        mapping = new int[c + 1];

        for (int i = 1; i <= c; i++) {
            if (mapping[i] == 0) {
                dfs(i, curr);
                curr++;
            }
        }   

        HashMap<Integer, TreeSet<Integer>> onlinegrid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int gridvalue = mapping[i];
            onlinegrid.putIfAbsent(gridvalue, new TreeSet<>());
            onlinegrid.get(gridvalue).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int node = query[1];

            int gridvalue = mapping[node];
            TreeSet<Integer> set = onlinegrid.get(gridvalue);

            if (type == 1) {
                if (set.contains(node)) {
                    ans.add(node);
                } else {
                    ans.add(set.isEmpty() ? -1 : set.first());
                }
            } else if (type == 2) {
                set.remove(node);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    void dfs(int node, int gridvalue) {
        if (mapping[node] != 0)
            return;
        mapping[node] = gridvalue;
        for (int nei : graph.get(node)) {
            if (mapping[nei] == 0) {
                dfs(nei, gridvalue);
            }
        }
    }
}