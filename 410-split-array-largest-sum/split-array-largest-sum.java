class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();

        while(l<=r){
            int mid = l+(r-l)/2;
            int part = isPossible(nums, mid);
            if(part>k){
                l =mid+1;
            }else{
                r =mid-1;
            }
        }
        
      return l;
    }

    public int isPossible(int[]nums, int mid){
        int parts =1;
        int sum=0;
        for(int i =0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }else{
                parts++;
                sum = nums[i];
            }
        }
        return parts;
    }
}