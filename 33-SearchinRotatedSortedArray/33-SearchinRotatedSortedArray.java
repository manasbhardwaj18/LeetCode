// Last updated: 5/22/2026, 9:45:47 AM
1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4        int low = 0, high = n-1;
5
6        while(low < high){
7            int mid = (low + high)/2;
8            if(nums[mid] > nums[n-1]) low = mid+1;
9            else high = mid;
10        }
11        int rotate = low;
12        int low1 = 0, high1 = n-1;
13
14        while(low1 <= high1){
15            int mid1 = (low1 + high1)/2;
16            int tgt = (mid1 + rotate) % n;
17
18            if(nums[tgt] == target) return tgt;
19
20            if(nums[tgt] < target) low1 = mid1 + 1;
21            else high1 = mid1 - 1;
22        }
23        return -1;
24    }
25}