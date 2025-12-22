// Last updated: 12/22/2025, 4:30:52 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs[0].length(), m = strs.length;
4        int[] dp = new int[n];
5        Arrays.fill(dp, 1);
6        for (int i = 1; i < n; i++) {
7            for (int j = 0; j < i; j++) {
8                if (isValid(strs, j, i)) {
9                    dp[i] = Math.max(dp[i], dp[j] + 1);
10                }
11            }
12        }
13        int max = 0;
14        for (int val : dp) max = Math.max(max, val);
15            return n - max;
16    }
17    
18    private boolean isValid(String[] strs, int j, int i) {
19        for (String s : strs) {
20            if (s.charAt(j) > s.charAt(i)) return false;
21        }
22    return true;
23    }
24}