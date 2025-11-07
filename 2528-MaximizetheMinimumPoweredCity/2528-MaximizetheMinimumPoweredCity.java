// Last updated: 11/7/2025, 5:24:40 PM
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = 0, right = k;
        for (int x: stations)
            right += x;
        long []v = new long[n];
        while (left <= right) {
            long x = (left + right) / 2;
            for (int i = 0; i < n; ++i) 
                v[i] = stations[i];
            long s = 0, use = 0;
            for (int i = 0; i < r; ++i) 
                s += v[i];
            for (int i = 0; i < n; ++i) {
                int t = Math.min(n - 1, i + r);
                if (i + r < n) s += v[i + r];
                if (i - r > 0) s -= v[i - r - 1];
                long diff = Math.max(0, x - s);
                v[t] += diff;
                s += diff;
                use += diff;
            }
            if (use <= k) left = x + 1;
            else right = x - 1;
        }
        return right;
    }
}