class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int count = 0;
        int diff = Integer.MIN_VALUE;
        int diffCount = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] == diff){
                diffCount++;
                count += diffCount;
            }else{
                diffCount = 0;
            }
            diff = nums[i] - nums[i-1];
        }
        return count;
    }
}