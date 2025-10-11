// Last updated: 10/11/2025, 11:54:24 AM
class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        long[] dp = new long[power.length];
        long md = 0;
        dp[0] = power[0];
        for (int i = 1, j = 0; i < power.length; i++) {
            if (power[i] == power[i-1]) {
                dp[i] = dp[i-1]+power[i];
            } else {
                while (power[j]+2 < power[i]) {
                    md = Math.max(md, dp[j]);
                    j++;
                }
                dp[i] = md + power[i];
            }
        }
        
        long max = 0;
        for (long n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }
}