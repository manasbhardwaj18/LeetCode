// Last updated: 6/10/2026, 3:38:32 PM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int min = nums[0], max = nums[0];
4        for(int num: nums){
5            min = Math.min(min, num);
6            max = Math.max(max, num);
7        }
8        return (long) (max - min)*k;
9    }
10}