// Last updated: 11/24/2025, 3:43:21 PM
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int msb=0;
        for(int x : nums){
            msb = ((msb*2)+x)%5;
            result.add(msb==0);
        }
        return result;
    }
}

