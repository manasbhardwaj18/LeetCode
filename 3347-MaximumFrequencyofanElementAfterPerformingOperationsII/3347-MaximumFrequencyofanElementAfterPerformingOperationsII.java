// Last updated: 10/22/2025, 3:52:17 PM
class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        Arrays.sort(nums);
        int n = nums.length;

        int l1 = 0;
        int r1 = 0;
        int w1 = 0;
        int res = 0;
        int l2 = 0;
        int w2 = 0;
        int same = 0;
        int prev = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == prev) {
                same++;
            } else {
                prev = num;
                same = 1;
            }

            while (nums[l1] < num - k) {
                w1--;
                l1++;
            }

            while (r1 < n && nums[r1] <= num + k) {
                w1++;
                r1++;
            }
            res = Math.max(res, same + Math.min(w1 - same, ops));

            w2++;
            while (nums[l2] < num - 2L * k) {
                w2--;
                l2++;
            }
            res = Math.max(res, Math.min(w2, ops));
        }

        return res;
    }
}