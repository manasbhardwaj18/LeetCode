// Last updated: 4/19/2026, 11:35:11 AM
1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int i, j;
4
5        for(i=0,j=0; i < nums1.length && j < nums2.length; j++){
6            if(nums1[i] > nums2[j]){
7                i++;
8            }
9        }
10        return Math.max(0, j-i-1);
11    }
12}