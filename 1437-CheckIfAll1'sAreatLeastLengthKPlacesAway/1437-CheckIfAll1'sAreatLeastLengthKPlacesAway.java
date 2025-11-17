// Last updated: 11/17/2025, 3:18:41 PM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        final int n = nums.length;
        int last = -1000;
        for(int i =0;i<n;i++ ){
            if(nums[i] == 1){
                if(i-last-1 < k){
                    return false;
                }
                last = i;
            }
        }
        return true;
    }
}