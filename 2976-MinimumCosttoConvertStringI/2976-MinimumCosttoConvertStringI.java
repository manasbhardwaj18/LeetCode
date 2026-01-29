// Last updated: 1/29/2026, 8:32:38 PM
1class Solution {
2    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
3        long[][] dist = new long[26][26];
4        long inf = Long.MAX_VALUE/2;
5
6        for(long[] row: dist){
7            Arrays.fill(row, inf);
8        }
9
10        for(int i=0; i<26; i++){
11            dist[i][i] = 0;
12        }
13
14        for(int i=0; i<original.length; i++){
15            int u = original[i] - 'a';
16            int v = changed[i] - 'a';
17            dist[u][v] = Math.min(dist[u][v], cost[i]);
18        }
19
20        for(int k=0; k<26; k++){
21            for(int i=0; i<26; i++){
22                if(dist[i][k] == inf){
23                    continue;
24                }
25                for(int j=0; j<26;j++){
26                    if(dist[k][j] != inf){
27                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
28                    }
29                }
30            }
31        }
32
33        long totalCost = 0;
34        int n= source.length();
35
36        for(int i=0; i <n; i++){
37            int u = source.charAt(i) - 'a';
38            int v = target.charAt(i) - 'a';
39            if(u==v){
40                continue;
41            }
42            if(dist[u][v] == inf){
43                return -1;
44            }
45            totalCost += dist[u][v]; 
46        }
47        return totalCost;
48    }
49}