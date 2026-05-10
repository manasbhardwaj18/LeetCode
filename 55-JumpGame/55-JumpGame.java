// Last updated: 5/10/2026, 10:58:34 AM
1class Solution {
2    public boolean canJump(int[] nums) {
3        int goal = nums.length - 1;
4
5        for(int i=nums.length-2; i>=0; i--){
6            if(i+nums[i] >= goal){
7                goal = i;
8            }
9        }
10        return goal==0;
11    }
12}