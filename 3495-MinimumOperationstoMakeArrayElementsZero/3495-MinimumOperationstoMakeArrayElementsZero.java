// Last updated: 9/6/2025, 12:19:44 PM
class Solution {
    private long computeSteps(long l, long r) {
        long cnt = 0, low = 1;
        for (int k = 1; ; k++) {
            if (low > r) break;
            long high = low * 4 - 1;
            long left = Math.max(l, low);
            long right = Math.min(r, high);
            if (left <= right) cnt += (right - left + 1) * k;
            low *= 4;
        }
        return cnt;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long ops = computeSteps(q[0], q[1]);
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}