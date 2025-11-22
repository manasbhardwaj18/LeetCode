// Last updated: 11/22/2025, 12:07:40 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for(int num : nums){
            if(num % 3 !=0) res++;
        }
        return res;
    }
}