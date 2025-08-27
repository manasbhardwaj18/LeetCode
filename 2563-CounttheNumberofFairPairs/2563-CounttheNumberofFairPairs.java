// Last updated: 8/27/2025, 1:27:10 PM
class Solution {
    public long countGoodIntegers(int n, int k) {
        long[][] comb = new long[11][11];
        for (int i = 0; i <= 10; i++) {
            comb[i][0] = comb[i][i] = 1;
        }
        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
            }
        }

        int base = 1;
        for (int i = 0; i < (n + 1) / 2; i++)
            base *= 10;

        Set<Long> encodedFreqs = new HashSet<>();

        for (int half = base / 10; half < base; half++) {
            long num = half;
            int mirror = (n % 2 == 1) ? half / 10 : half;
            for (int j = 0; j < n / 2; j++) {
                num = num * 10 + (mirror % 10);
                mirror /= 10;
            }
            if (num % k == 0) {
                int[] freq = new int[10];
                long temp = num;
                for (int i = 0; i < n; i++) {
                    freq[(int)(temp % 10)]++;
                    temp /= 10;
                }
                long code = 0;
                for (int i = 0; i < 10; i++) {
                    code = code * 11 + freq[i];
                }
                encodedFreqs.add(code);
            }
        }

        long total = 0;
        for (long code : encodedFreqs) {
            int[] freq = new int[10];
            for (int i = 9; i >= 0; i--) {
                freq[i] = (int)(code % 11);
                code /= 11;
            }
            long ways = 1;
            int rem = n;
            for (int i = 0; i < 10; i++) {
                if (freq[i] > rem) {
                    ways = 0;
                    break;
                }
                ways *= comb[i == 0 ? rem - 1 : rem][freq[i]];
                rem -= freq[i];
            }
            total += ways;
        }

        return total;
    }
}