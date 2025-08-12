class Solution {
    static final int MOD = 1_000_000_007;
    Map<String, Integer> memo = new HashMap<>();

    public int numberOfWays(int n, int x) {
        return dfs(n, 1, x);
    }

    private int dfs(int remaining, int current, int x) {
        if (remaining == 0) return 1;
        if (remaining < 0 || Math.pow(current, x) > remaining) return 0;

        String key = remaining + "," + current;
        if (memo.containsKey(key)) return memo.get(key);

        int power = (int) Math.pow(current, x);
        int include = dfs(remaining - power, current + 1, x);
        int skip = dfs(remaining, current + 1, x);

        int total = (include + skip) % MOD;
        memo.put(key, total);
        return total;
    }
}