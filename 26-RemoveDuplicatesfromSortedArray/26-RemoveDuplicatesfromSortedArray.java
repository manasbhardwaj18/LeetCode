// Last updated: 5/5/2026, 10:09:41 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int idx = 0;
4        for(int last = 1; last < nums.length;){
5            if(nums[last] == nums[idx]){
6                last++;
7            }else{
8                nums[idx+1] = nums[last];
9                idx++;
10            }
11        }
12        return idx+1;
13    }
14}
15
16