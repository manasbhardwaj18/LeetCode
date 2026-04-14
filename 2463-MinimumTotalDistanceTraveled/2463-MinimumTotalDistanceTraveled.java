// Last updated: 4/14/2026, 2:06:18 PM
1class Solution {
2    long[][] dp;
3
4    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
5        Collections.sort(robot);
6        Arrays.sort(factory, (a,b) -> a[0] - b[0]);
7
8        int n = robot.size();
9        int m = factory.length;
10
11        dp = new long[n][m];
12        for(long[] row : dp) Arrays.fill(row, -1);
13        return solve(0,0, robot, factory);
14    }
15
16    long solve(int i, int j, List<Integer> robot, int[][] factory){
17        int n = robot.size();
18        int m = factory.length;
19        if(i == n) return 0;
20        if(j == m) return (long)1e15;
21
22        if(dp[i][j] != -1) return dp[i][j];
23
24        long res = solve(i, j+1, robot, factory);
25
26        long cost = 0;
27        int pos = factory[j][0];
28        int limit = factory[j][1];
29
30        for(int k = 0; k < limit && i+k <n; k++){
31            cost += Math.abs(robot.get(i+k)-pos);
32            res = Math.min(res, cost + solve(i+k+1, j+1, robot, factory));
33        } 
34        return dp[i][j] = res;
35    }
36}