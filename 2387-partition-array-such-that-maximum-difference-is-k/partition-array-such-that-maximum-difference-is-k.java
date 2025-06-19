class Solution {
    public int partitionArray(int[] nums, int k) {
        int[] frq = new int[100001];

        int mx = 0, mn = Integer.MAX_VALUE;
        for (int val : nums) {
            frq[val] = 1;
            mx = Math.max(mx, val);
            mn = Math.min(mn, val);
        }

        int section = 0;
        int range = -1;
        for (int num = mn; num <= mx; num++) {
            if (frq[num] == 1) {
                if (range < num) {
                    range = num + k;
                    section++;
                }
            }
            if (range >= mx) {
                break;
            }
        }

        return section;
    }
}