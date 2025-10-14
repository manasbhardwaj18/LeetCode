// Last updated: 10/14/2025, 1:53:17 PM
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i = 0;i+2*k <= n ;i++){
            if ( isInc(nums, i ,i+k-1) && isInc(nums, i+k,i+2*k-1) ){
                return true;
            }
        }
        return false;
    }
     boolean isInc(List<Integer> nums, int start, int end){
        for(int i=start;i<end;i++){
            if(nums.get(i) >= nums.get(i+1)){
                return false;
            }
           
        }
return true;
    }
}