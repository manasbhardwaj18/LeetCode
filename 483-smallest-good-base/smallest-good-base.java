class Solution {
    public String smallestGoodBase(String n) {
        long low = Long.valueOf(n);
        int high = (int) (Math.log(low + 1) / Math.log(2)) - 1;
        
        long result = low - 1;
        for (int m = high; m > 1; m--) {
            long k = (long) Math.pow(low, 1.0 / m);
            if (geometric(k, m) == low) return String.valueOf(k);
        }
        return String.valueOf(result);
    }

    private long geometric(long base, int m) {
        long result = 0;
        for (int i = 0; i <= m; i++) {
            result = 1 + result * base;
        }
        return result;
    }
}