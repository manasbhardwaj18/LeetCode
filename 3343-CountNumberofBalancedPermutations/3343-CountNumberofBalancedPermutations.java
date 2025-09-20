// Last updated: 9/20/2025, 1:02:59 PM
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        int minWindowSize = set.size();
        int count = 0;
        for(int i = 0 ; i < nums.length; i++){
            set.clear();
            for(int j = i ; j < nums.length; j++){
                set.add(nums[j]);
                if(set.size() == minWindowSize){
                    count += (nums.length - j);
                    break;
                }
            }
        }

        return count;
    }
}