class Solution {
    public int dominantIndex(int[] nums) {
        int maxVal = -1, maxId = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxId = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == maxId)
                continue;

           
            if (maxVal < 2 * nums[i]) {
                return -1;
            }
        }

        return maxId;
    }
}