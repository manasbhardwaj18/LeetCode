// Last updated: 5/5/2026, 9:46:04 AM
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        if(n == 0) return;
4        int l1 = nums1.length;
5        int end = l1 - 1;
6
7        while(n > 0 && m > 0){
8            if(nums2[n-1] >= nums1[m-1]){
9                nums1[end] = nums2[n-1];
10                n--;
11            }else{
12                nums1[end] = nums1[m-1];
13                m--;
14            }
15            end--;
16        }
17        while(n > 0){
18            nums1[end] = nums2[n-1];
19            n--;
20            end--;
21        }
22    }
23}