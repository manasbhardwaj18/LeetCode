// Last updated: 2/1/2026, 12:29:42 PM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int no1 = nums[0];
4        Arrays.sort(nums,1,nums.length);
5        return no1 + nums[1] + nums[2];
6
7    }
8}