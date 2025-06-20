class Solution {
    private void compute(int dir1, int dir2, int dir3, int dir4, int[] k_cnt, int[] dist) {
        dist[dir1] += (k_cnt[dir1] > 0) ? 1 : -1;
        k_cnt[dir1]--;

        dist[dir2] += (k_cnt[dir2] > 0) ? 1 : -1;
        k_cnt[dir2]--;

        dist[dir3]++;
        dist[dir4]++;
    }

    public int maxDistance(String s, int k) {
        if (s.length() == k) return k;

        int mx = 0;
        int[] k_cnt = new int[4];
        int[] dist = new int[4];
        Arrays.fill(k_cnt, k);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'N') {
                compute(1, 3, 0, 2, k_cnt, dist);
            } else if (ch == 'E') {
                compute(2, 3, 1, 0, k_cnt, dist);
            } else if (ch == 'W') {
                compute(0, 1, 2, 3, k_cnt, dist);
            } else { // 'S'
                compute(0, 2, 1, 3, k_cnt, dist);
            }

            mx = Math.max(mx, Math.max(Math.max(dist[0], dist[1]), Math.max(dist[2], dist[3])));
        }

        return mx;
    }
}