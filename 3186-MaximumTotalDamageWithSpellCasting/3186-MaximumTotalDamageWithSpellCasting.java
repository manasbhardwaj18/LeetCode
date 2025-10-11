// Last updated: 10/11/2025, 11:53:57 AM
public class Solution {
    private int sz;
    private List<long[]> spell;
    private long[] dp;

    private long f(int i) {
        if (i >= sz) return 0;
        if (dp[i] != -1) return dp[i];
        long notake = f(i + 1);
        int j = i + 1;
        int x = (int) spell.get(i)[0];
        while (j < sz && spell.get(j)[0] <= x + 2) j++;
        long take = spell.get(i)[1] + f(j);
        return dp[i] = Math.max(take, notake);
    }

    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        if (n == 0) return 0;
        Arrays.sort(power);
        spell = new ArrayList<>();
        spell.add(new long[]{power[0], power[0]});
        for (int i = 1; i < n; i++) {
            int x = power[i];
            if (x != power[i - 1]) spell.add(new long[]{x, x});
            else spell.get(spell.size() - 1)[1] += x;
        }
        sz = spell.size();
        dp = new long[sz];
        Arrays.fill(dp, -1L);
        return f(0);
    }
}