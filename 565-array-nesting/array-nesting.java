class Solution {
    public int arrayNesting(int[] nums){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-1){
            int j=i;
            int count=0;
            while(nums[j]!=-1){
                int k=nums[j];
                nums[j]=-1;
                j=k;
                count++;
            }
            ans=Math.max(ans,count);
            if(ans==nums.length) return ans;
            }
        }
        return ans;
    }
}