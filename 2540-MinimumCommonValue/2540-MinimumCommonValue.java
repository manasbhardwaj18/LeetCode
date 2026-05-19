// Last updated: 5/19/2026, 11:04:45 AM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int m = nums1.length, n = nums2.length;
4
5        int i=0,j=0;
6
7        while(i<m && j<n){
8            if(nums1[i] == nums2[j]){
9                return nums1[i];
10            }else if(nums1[i] < nums2[j]){
11                i++;
12            }else{
13                j++;
14            }
15        }
16        return -1;
17    }
18}