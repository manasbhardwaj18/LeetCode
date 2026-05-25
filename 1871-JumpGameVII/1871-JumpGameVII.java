// Last updated: 5/25/2026, 10:20:04 AM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        if(s.charAt(n-1) == '1') return false;
5
6        boolean[] dp = new boolean[n];
7        dp[0] = true;
8
9        int reach = 0;
10
11        for(int i=1; i<n; i++){
12            if(i>= minJump && dp[i-minJump]) reach++;
13            if(i > maxJump && dp[i-maxJump-1]) reach--;
14            if(reach > 0 && s.charAt(i) == '0') dp[i] = true;
15        }
16        return dp[n-1];
17    }
18}