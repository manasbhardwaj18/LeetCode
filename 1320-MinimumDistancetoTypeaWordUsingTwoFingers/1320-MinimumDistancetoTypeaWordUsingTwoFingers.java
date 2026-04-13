// Last updated: 4/13/2026, 10:36:47 PM
1class Solution {
2    public int dist(int a, int b){
3        if(a==26 || b == 26){
4            return 0;
5        }
6        return Math.abs(a/6 - b/6) + Math.abs(a%6 - b%6);
7    }
8    public int minimumDistance(String word) {
9        int[] dp = new int[27];
10        Arrays.fill(dp, 1000000);
11        dp[26] = 0;
12        int prev = word.charAt(0) - 'A';
13
14        for(int i=1; i< word.length(); i++){
15            int cur = word.charAt(i)-'A';
16            int[] next_dp = new int[27];
17            Arrays.fill(next_dp, 1000000);
18            for(int free = 0; free < 27; free++){
19                if(dp[free]>= 1000000){
20                    continue;
21                }
22                next_dp[free] = Math.min(next_dp[free], dp[free] + dist(prev, cur));
23                next_dp[prev] = Math.min(next_dp[prev], dp[free] + dist(free, cur));
24            }
25            dp = next_dp;
26            prev = cur;
27        }
28        int res = 1000000;
29        for(int v : dp){
30            res = Math.min(res,v);
31        }
32        return res;
33    }
34}