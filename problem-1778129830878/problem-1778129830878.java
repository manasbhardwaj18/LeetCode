// Last updated: 5/7/2026, 10:27:10 AM
1class Solution {
2    public int majorityElement(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        return nums[n/2];
6    }
7}