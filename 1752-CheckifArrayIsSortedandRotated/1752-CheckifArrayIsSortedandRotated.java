// Last updated: 5/23/2026, 10:12:19 AM
1class Solution {
2    public boolean check(int[] nums) {
3        int n = nums.length;
4        int breaks = 0;
5
6        for(int i=0; i <n ; i++){
7            if(nums[i] > nums[(i+1)%n]){
8                breaks++;
9            }
10        }
11        return breaks <= 1;
12    }
13}