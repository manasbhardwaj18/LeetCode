import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);
        int res = nums[n - 1] - nums[0]; 

        for (int i = 0; i < n - 1; i++) {
            int maxi = Math.max(nums[n - 1] - k, nums[i] + k);
            int mini = Math.min(nums[0] + k, nums[i + 1] - k);
            res = Math.min(res, maxi - mini);
        }

        return res;
    }
}