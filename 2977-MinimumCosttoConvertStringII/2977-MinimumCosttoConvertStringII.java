// Last updated: 1/31/2026, 12:12:12 AM
1class Solution {
2    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
3        HashMap<String, Integer> index = new HashMap<>();
4        for(String o : original){
5            if(!index.containsKey(o)){
6                index.put(o, index.size());
7            }
8        }
9        for(String c : changed){
10            if(!index.containsKey(c)){
11                index.put(c, index.size());
12            }
13        }
14
15        long[][] dis = new long[index.size()][index.size()];
16        for(int i=0; i <dis.length; i++){
17            Arrays.fill(dis[i], Long.MAX_VALUE);
18            dis[i][i] = 0;
19        }
20
21        for(int i=0; i<cost.length;i++){
22            dis[index.get(original[i])][index.get(changed[i])] = Math.min(dis[index.get(original[i])][index.get(changed[i])], (long)cost[i] );
23        }
24
25        for(int k=0; k<dis.length; k++){
26            for(int i=0; i<dis.length;i++){
27                if(dis[i][k] < Long.MAX_VALUE){
28                    for(int j=0; j<dis.length;j++){
29                        if(dis[k][j] < Long.MAX_VALUE){
30                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
31                        }
32                    }
33                }
34            }
35        }
36
37        HashSet<Integer> set = new HashSet<>();
38        for(String o : original){
39            set.add(o.length());
40        }
41        long[] dp = new long[target.length() + 1];
42        Arrays.fill(dp, Long.MAX_VALUE);
43        dp[0] = 0L;
44
45        for(int i=0; i<target.length();i++){
46            if(dp[i] == Long.MAX_VALUE){
47                continue;
48            }
49            if(target.charAt(i) == source.charAt(i)){
50                dp[i+1] = Math.min(dp[i+1], dp[i]);
51            }
52
53            for(int t: set){
54                if(i+t >= dp.length){
55                    continue;
56                }
57
58                int c1 = index.getOrDefault(source.substring(i, i+t), -1);
59                int c2 = index.getOrDefault(target.substring(i, i+t), -1);
60                if(c1 >= 0 && c2 >= 0 && dis[c1][c2] < Long.MAX_VALUE){
61                    dp[i+t] = Math.min(dp[i+t],dp[i] + dis[c1][c2]);
62                }
63            }
64        }
65        return dp[dp.length - 1] == Long.MAX_VALUE ? -1L : dp[dp.length -1];
66    }
67}