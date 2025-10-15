// Last updated: 10/15/2025, 12:53:19 PM

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans=0,prev=0,count=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)) count++;
            else{
                prev=count;
                count=1;
            }
            ans=Math.max(ans,Math.max(count/2,Math.min(prev,count)));
        }
        return ans;
    }
}