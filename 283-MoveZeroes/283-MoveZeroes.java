// Last updated: 5/13/2026, 12:51:09 PM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int left = 0;
4        for(int right = 0; right < nums.length; right++){
5            if(nums[right] != 0){
6                int temp = nums[right];
7                nums[right] = nums[left];
8                nums[left] = temp;
9                left++;
10            }
11        }
12    }
13}