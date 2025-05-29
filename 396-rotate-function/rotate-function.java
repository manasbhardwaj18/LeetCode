class Solution {
    public int maxRotateFunction(int[] nums) {

      int sum=0;
      int f=0;
      int n=nums.length;

      for(int i=0;i<n;i++)
      {
          sum+=nums[i];
          f+=i*nums[i];

      }  

      int max=f;
      for(int i=n-1;i>0;i--)
      {
          max=Math.max(max,f+sum-(n*nums[i]));
          f=f+sum-(n*nums[i]);

      }

      return max;
    }
}