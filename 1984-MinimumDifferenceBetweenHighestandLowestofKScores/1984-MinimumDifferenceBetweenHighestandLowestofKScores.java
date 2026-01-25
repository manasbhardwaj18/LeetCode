// Last updated: 1/25/2026, 7:32:07 PM
1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        Arrays.sort(nums);
4        int n= nums.length;
5        int res = nums[k-1] - nums[0];
6        for(int i=0;i+k<=n;i++){
7            res = Math.min(res, nums[i+k-1] - nums[i]);
8        }
9        return res;
10    }
11}