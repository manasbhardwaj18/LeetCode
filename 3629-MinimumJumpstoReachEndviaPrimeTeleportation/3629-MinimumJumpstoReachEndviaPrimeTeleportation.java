// Last updated: 5/8/2026, 9:39:38 AM
1class Solution {
2    private static final int MAX_RANGE = 1_000_000 + 1;
3    private static final boolean[] prime = new boolean[MAX_RANGE];
4
5    static{
6        Arrays.fill(prime, true);
7        prime[0] = prime[1] = false;
8
9        for(int i=2; i*i < MAX_RANGE; i++){
10            if(prime[i] == true){
11                for(int j = i*i ; j < MAX_RANGE; j += i){
12                    prime[j] = false;
13                }
14            }
15        }
16    }
17
18    public int minJumps(int[] nums) {
19        int n = nums.length;
20        int maxi = 0;
21
22        Map<Integer, List<Integer>> val_to_index = new HashMap<>();
23        for(int i=0; i<n; i++){
24            maxi = Math.max(maxi, nums[i]);
25            val_to_index.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
26        } 
27
28        Set<Integer> visited = new HashSet<>();
29        int[] dist = new int[n];
30        Arrays.fill(dist, Integer.MAX_VALUE);
31        dist[0] = 0;
32
33        Queue<Integer> q = new ArrayDeque<>();
34        q.offer(0); 
35
36        while (!q.isEmpty()) {
37            int node = q.poll();
38
39            if (node - 1 >= 0 && dist[node - 1] == Integer.MAX_VALUE) {
40                q.offer(node - 1);
41                dist[node - 1] = 1 + dist[node];
42            }
43
44            if (node + 1 < n && dist[node + 1] == Integer.MAX_VALUE) {
45                q.offer(node + 1);
46                dist[node + 1] = 1 + dist[node];
47            }
48
49            if (!prime[nums[node]] || visited.contains(nums[node])) {
50                continue;
51            }
52
53            int i = 1;
54            while (true) {
55                long new_node_val = (long) nums[node] * i; 
56                if (new_node_val > maxi) {
57                    break;
58                }
59                
60                int new_node = (int)new_node_val;
61
62                if (val_to_index.containsKey(new_node)) {
63                    for (int new_node_index : val_to_index.get(new_node)) {
64                        if (dist[new_node_index] == Integer.MAX_VALUE) {
65                            q.offer(new_node_index);
66                            dist[new_node_index] = 1 + dist[node];
67                        }
68                    }
69                }
70                i++;
71            }
72
73            visited.add(nums[node]);
74
75            if (dist[n - 1] != Integer.MAX_VALUE) { 
76                break;
77            }
78        }
79        
80        return dist[n - 1];
81    
82    }
83}