// Last updated: 5/27/2026, 11:33:06 AM
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        for(int j=0, i=m; j < n; j++){
4            nums1[i] = nums2[j];
5            i++;
6        }
7        Arrays.sort(nums1);
8    }
9}