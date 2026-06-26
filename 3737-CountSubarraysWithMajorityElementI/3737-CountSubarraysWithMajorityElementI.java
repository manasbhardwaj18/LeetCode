// Last updated: 6/26/2026, 1:58:50 PM
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int res = 0;
5
6        for(int left=0; left < n; left++){
7            int tgt = 0;
8
9            for(int right = left; right < n; right++){
10                if(nums[right] == target){
11                    tgt++;
12                }
13                int len = right - left + 1;
14                if(tgt > len/2){
15                    res++;
16                }
17            }
18        }
19        return res;
20    }
21}