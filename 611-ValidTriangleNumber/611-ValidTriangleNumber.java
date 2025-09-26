// Last updated: 9/26/2025, 3:58:21 PM
class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int c=n-1;c>=2;c--){
            int a=0;
            int b=c-1;
            while(a<b){
                if(nums[a]+nums[b]>nums[c]){
                    count+=(b-a);
                    b--;
                }
                else{
                    a++;
                }
            }
             
        }
       
         return count;
    }
     
}