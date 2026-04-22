// Last updated: 4/22/2026, 9:36:17 PM
1class Solution {
2    int[] parent;
3
4    int find(int x){
5        if(parent[x] != x) parent[x] = find(parent[x]);
6        return parent[x];
7    }
8    void unite(int a, int b){
9        parent[find(a)] = find(b);
10    }
11
12    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
13        int n = source.length;
14        parent = new int[n];
15
16        for(int i=0; i<n; i++) parent[i] = i;
17
18        for(int[] swap : allowedSwaps){
19            unite(swap[0], swap[1]);
20        }
21
22        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
23        for(int i=0; i<n; i++){
24            int root = find(i);
25            groups.computeIfAbsent(root, k -> new HashMap<>()).merge(source[i], 1, Integer::sum);
26        }
27
28        int hammingDist = 0;
29        for(int i=0; i< n; i++){
30            int root = find(i);
31            Map<Integer, Integer> freq = groups.get(root);
32
33            if(freq.getOrDefault(target[i], 0) > 0){
34                freq.merge(target[i], -1, Integer::sum);
35            }else{
36                hammingDist++;
37            }
38        }
39        return hammingDist;
40    }
41}