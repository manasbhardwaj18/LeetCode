class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int maxDiff = 0;
        int maxNum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, (long) maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxNum - nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }
        if(max<0) return 0;
        else return max;
    }
}