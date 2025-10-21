// Last updated: 10/21/2025, 1:55:42 PM
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length, ans = 0, left = 0, right = 0;
        Arrays.sort(nums);

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        for(int mid = 0; mid < n; mid++) {
            while(nums[mid] - nums[left] > k) {
                left++;
            }

            while(right < n - 1 && nums[right + 1] - nums[mid] <= k) {
                right++;
            }

            int total = right - left + 1;
            ans = Math.max(ans, Math.min(total - count.get(nums[mid]), numOperations) + count.get(nums[mid]));
        }

        left = 0;
        for(right = 0; right < n; right++) {
            int mid = (nums[left] + nums[right]) / 2;

            while(mid - nums[left] > k || nums[right] - mid > k) {
                left++;
                mid = (nums[left] + nums[right]) / 2;
            }
            ans = Math.max(ans, Math.min(right - left + 1, numOperations));
        }

        return ans;
    }
}