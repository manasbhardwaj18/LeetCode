class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] seg = new int[4*n];
        int ans = 0;
        buildTree(baskets, seg, 0, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (fruits[i] > seg[0])
                ans++;
            else {
                if (!solve(seg, 0, 0, n - 1, fruits[i]))
                    ans++;
            }
        }
        return ans;
    }

    private int buildTree(int[] nums, int[] seg, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = nums[l];
            return seg[idx];
        }
        int mid = l + (r - l) / 2;
        seg[idx] = Math.max(buildTree(nums, seg, 2 * idx + 1, l, mid),
                buildTree(nums, seg, 2 * idx + 2, mid + 1, r));
        return seg[idx];
    }

    private boolean solve(int[] seg, int idx, int l, int r, int val) {
        if (l == r) {
            seg[idx] = -1;
            return true;
        }
        int mid = l + (r - l) / 2;
        boolean left = false;
        boolean right = false;
        if(seg[2*idx+1]>=val){
            left = solve(seg, 2*idx+1, l, mid, val);
        }else{
            right = solve(seg, 2*idx+2, mid+1, r, val);
        }
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
        return left || right;
    }
}