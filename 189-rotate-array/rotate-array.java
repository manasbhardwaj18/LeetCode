class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        
        int[] temp = new int[k];
        System.arraycopy(nums, n - k, temp, 0, k);
        
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i+k ] = nums[i];
        }
        
        System.arraycopy(temp, 0, nums, 0, k);
    }
}