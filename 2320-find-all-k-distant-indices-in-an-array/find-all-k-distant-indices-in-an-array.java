class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int left = Math.max(right, i - k);
                right = Math.min(n, i + k + 1);
                for (int j = left; j < right; j++) {
                    ans.add(j);
                }
            }
        }
        return ans;
    }
}