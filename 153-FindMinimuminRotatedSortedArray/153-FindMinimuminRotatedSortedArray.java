// Last updated: 5/15/2026, 9:59:08 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int min = nums[0];
4        for (int i=0;i<nums.length;i++){
5            if (nums[i]<min){
6                min  = nums[i];
7            }
8        }
9        return min;
10    }
11}