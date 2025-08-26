// Last updated: 8/26/2025, 10:14:40 PM
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;

            long take = points + (next < n ? dp[next] : 0);
            long skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}