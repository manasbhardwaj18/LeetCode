class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int m = edges.length;

        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> children = new ArrayList<>();
        int[] xor = nums.clone();
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            children.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        int total = 0;
        for (int val : nums)
            total ^= val;

        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
                seen[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!seen[next]) {
                    children.get(next).add(curr);
                    for (int ch : children.get(curr)) {
                        children.get(next).add(ch);
                    }
                    xor[next] ^= xor[curr];
                }
                degree[next]--;
                if (degree[next] == 1 && !seen[next]) {
                    seen[next] = true;
                    queue.add(next);
                }
            }
        }

        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int a = edges[i][0], b = edges[i][1];
                if (children.get(a).contains(b)) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                int c = edges[j][0], d = edges[j][1];
                if (children.get(c).contains(d)) {
                    int tmp = c;
                    c = d;
                    d = tmp;
                }

                int[] parts;
                if (children.get(a).contains(c)) {
                    parts = new int[] { xor[c], xor[a] ^ xor[c], total ^ xor[a] };
                } else if (children.get(c).contains(a)) {
                    parts = new int[] { xor[a], xor[c] ^ xor[a], total ^ xor[c] };
                } else {
                    parts = new int[] { xor[a], xor[c], total ^ xor[a] ^ xor[c] };
                }

                int max = Math.max(parts[0], Math.max(parts[1], parts[2]));
                int min = Math.min(parts[0], Math.min(parts[1], parts[2]));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }
}