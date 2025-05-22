
public class Solution {
    private static final int MOD = 1_000_000_007;
    private static final long[][] comb = pascalTriangle();

    private static long[][] pascalTriangle() {
        long[][] c = new long[41][41];
        for (int i = 0; i < 41; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j <= i / 2; j++) {
                long val = c[i - 1][j - 1] + c[i - 1][j];
                if (val >= MOD) val -= MOD;
                c[i][j] = c[i][i - j] = val;
            }
        }
        return c;
    }

    private int[] freq = new int[10];
    private int sum, n;
    private Map<Long, Integer> dp = new HashMap<>();

    public int countBalancedPermutations(String num) {
        Arrays.fill(freq, 0);
        sum = 0;
        n = num.length();
        for (char c : num.toCharArray()) {
            int d = c - '0';
            freq[d]++;
            sum += d;
        }
        if ((sum & 1) != 0) return 0;
        sum /= 2;
        int odd = n / 2, even = n - odd;
        dp.clear();
        return f(9, even, odd, sum);
    }

    private int f(int i, int even, int odd, int remain) {
        if (even == 0 && odd == 0 && remain == 0) return 1;
        if (i < 0 || even < 0 || odd < 0 || remain < 0) return 0;

        long key = (((long)i << 42) | ((long)even << 36) | ((long)odd << 30) | remain);
        if (dp.containsKey(key)) return dp.get(key);

        long ans = 0;
        int maxJ = Math.min(freq[i], even);
        for (int j = 0; j <= maxJ; j++) {
            int oddRem = freq[i] - j;
            if (oddRem > odd || remain < i * j) continue;
            if (remain - i * j > (even - j + odd - oddRem) * (i - 1)) continue;

            long ways = comb[even][j] * comb[odd][oddRem] % MOD;
            ans = (ans + ways * f(i - 1, even - j, odd - oddRem, remain - i * j) % MOD) % MOD;
        }
        dp.put(key, (int) ans);
        return (int) ans;
    }
}