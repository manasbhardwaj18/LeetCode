public class Solution {
    public int dist(int size, int p, int t) {
        return Math.min(Math.abs(t - p), size - Math.abs(t - p));
    }

    public int findRotateSteps(String ring, String key) {
        int[][] mp = new int[26][100];
        int[] freq = new int[26];
        int[][] dp = new int[100][100];

        int n = ring.length(), m = key.length();
        for (int i = 0; i < n; ++i) {
            mp[ring.charAt(i) - 'a'][freq[ring.charAt(i) - 'a']++] = i;
        }

        for (int i = 0; i < freq[key.charAt(0) - 'a']; ++i) {
            dp[0][mp[key.charAt(0) - 'a'][i]] = dist(n, 0, mp[key.charAt(0) - 'a'][i]) + 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < freq[key.charAt(i) - 'a']; ++j) {
                int mini = Integer.MAX_VALUE;
                for (int k = 0; k < freq[key.charAt(i - 1) - 'a']; ++k) {
                    mini = Math.min(mini, dp[i - 1][mp[key.charAt(i - 1) - 'a'][k]] +
                            dist(n, mp[key.charAt(i) - 'a'][j], mp[key.charAt(i - 1) - 'a'][k]) + 1);
                }

                dp[i][mp[key.charAt(i) - 'a'][j]] = mini;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < freq[key.charAt(m - 1) - 'a']; ++i) {
            res = Math.min(res, dp[m - 1][mp[key.charAt(m - 1) - 'a'][i]]);
        }

        return res;
    }
}