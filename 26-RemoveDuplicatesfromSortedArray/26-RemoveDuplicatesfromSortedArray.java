// Last updated: 5/5/2026, 9:54:38 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int j = 0;
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[j] != nums[i]) {
6                nums[++j] = nums[i];
7                
8            }
9        }
10        return ++j;
11    }
12}