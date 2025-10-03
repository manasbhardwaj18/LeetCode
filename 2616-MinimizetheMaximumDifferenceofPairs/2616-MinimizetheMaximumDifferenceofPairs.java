// Last updated: 10/3/2025, 8:42:05 PM
import java.util.*;

class Solution {
    public int minimizeMax(int[] v, int p) {
        Arrays.sort(v); 
        int n = v.length;
        int lo = -1, hi = (int)1e9 + 7;

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;

            for (int i = 1; i < n; i++) {
                if (v[i] - v[i - 1] <= mid) {
                    count++;
                    i++; 
                }
            }

            if (count >= p) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }
}