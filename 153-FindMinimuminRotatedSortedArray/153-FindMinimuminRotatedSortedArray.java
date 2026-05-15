// Last updated: 5/15/2026, 10:09:14 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length - 1;
4        int last = nums[n];
5        int left = 0, right = n;
6
7        while(left < right){
8            int mid = ( left + right ) / 2;
9            if(nums[mid] > last) left  = mid + 1;
10            else right = mid;
11        }
12        return nums[left]; 
13   }
14}