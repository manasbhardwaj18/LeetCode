// Last updated: 11/19/2025, 11:47:26 AM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while(true){
            int left =0, right=nums.length-1;
            boolean found = false;

            while(left<=right){
                int mid = left+(right-left)/2;
                if(nums[mid] == original){
                    found = true;
                    break;
                }else if(nums[mid]<original){
                    left = mid +1;
                }else{
                    right = mid - 1;
                }
            }
            if(found){
                original *= 2;
            }else{
                break;
            }
        }
        return original;
    }
}