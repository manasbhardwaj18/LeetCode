class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) vals[i] = s.charAt(i) - '0';
        int res = Integer.MIN_VALUE;
        int[] d = new int[n+1], pa = new int[n+1], cb = new int[n+1];
        int[][] cb_list = new int[4][n+1], dm = new int[4][n+1];
        int[] ptr = new int[4], sz = new int[4];
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) continue;
                d[0] = pa[0] = cb[0] = 0;
                for (int i = 1; i <= n; i++) {
                    int v = vals[i-1], da = (v==a)?1:0, db = (v==b)?1:0;
                    d[i] = d[i-1] + da - db;
                    pa[i] = pa[i-1] ^ da;
                    cb[i] = cb[i-1] + db;
                }
                for (int t = 0; t < 4; t++) { ptr[t] = 0; sz[t] = 0; }
                for (int j = k; j <= n; j++) {
                    int i = j - k;
                    int idx = (pa[i] << 1) | (cb[i] & 1);
                    int di = d[i], szi = sz[idx];
                    dm[idx][szi] = (szi==0?di:Math.min(dm[idx][szi-1], di));
                    cb_list[idx][szi] = cb[i];
                    sz[idx] = szi + 1;
                    int tidx = ((pa[j] ^ 1) << 1) | (cb[j] & 1), T = cb[j] - 2, p = ptr[tidx], szt = sz[tidx];
                    while (p < szt && cb_list[tidx][p] <= T) p++;
                    ptr[tidx] = p;
                    if (p > 0) {
                        int diff = d[j] - dm[tidx][p-1];
                        if (diff > res) res = diff;
                    }
                }
            }
        }
        return res;
    }
}