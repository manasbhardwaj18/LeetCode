class Solution {
    public int arrangeCoins(int n) {
        for (long i = 1; ; i++) {
            long sum = (i * (i + 1)) / 2;
            if (sum > n) return (int)(i - 1);
            if (sum == n) return (int)i;
        }
    }
}