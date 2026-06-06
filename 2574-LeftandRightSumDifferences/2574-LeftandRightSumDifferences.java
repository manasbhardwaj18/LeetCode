// Last updated: 6/6/2026, 3:31:55 PM
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int rSum = 0, lSum = 0;
4        for(int num : nums){
5            rSum += num;
6        }
7
8        int[] res = new int[nums.length];
9
10        for(int i=0; i<nums.length; i++){
11            rSum -= nums[i];
12            res[i] = Math.abs(lSum - rSum);
13            lSum += nums[i];
14        } 
15        return res;
16    }
17}