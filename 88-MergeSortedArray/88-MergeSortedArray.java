// Last updated: 5/17/2026, 11:14:12 AM
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        int i = m-1;
4        int j = n-1;
5        int fin = m+n-1;
6
7        while(j >= 0){
8            if(i >= 0 && nums1[i] > nums2[j]){
9                nums1[fin] = nums1[i];
10                i--;
11            }else{
12                nums1[fin] = nums2[j];
13                j--;
14            }
15            fin--;
16        }
17    }
18}