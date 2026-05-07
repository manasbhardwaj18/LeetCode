// Last updated: 5/7/2026, 10:08:20 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int k=2;
4        for(int i=2; i<nums.length; i++){
5            if(nums[i] != nums[k-2]){
6                nums[k] = nums[i];
7                k++;
8            }
9        }
10        return k;
11    }
12}