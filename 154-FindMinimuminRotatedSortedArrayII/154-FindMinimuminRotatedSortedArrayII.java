// Last updated: 5/16/2026, 11:28:01 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int st = 0, end = nums.length-1;
4        while (st < end) {
5            int mid = st + (end - st) / 2;
6            if (nums[mid] > nums[end]) {
7                st = mid + 1;
8            } else if (nums[mid] < nums[end]) {
9                end = mid; 
10            } else {
11                end--;
12            }
13        }
14        return nums[st];
15    }
16}