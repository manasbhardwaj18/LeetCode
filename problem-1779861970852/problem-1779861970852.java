// Last updated: 5/27/2026, 11:36:10 AM
1//class Solution {
2//    public void merge(int[] nums1, int m, int[] nums2, int n) {
3//      for(int j=0, i=m; j < n; j++){
4//            nums1[i] = nums2[j];
5//            i++;
6//        }
7//       Arrays.sort(nums1);
8//    }
9//}
10
11class Solution{
12    public void merge(int[] nums1, int m, int[] nums2, int n){
13        int i= m-1, j=n-1, k = m+n-1;
14
15        while(j >= 0){
16            if(i >= 0 && nums1[i] > nums2[j]){
17                nums1[k--] = nums1[i--];
18            }else{
19                nums1[k--] = nums2[j--];
20            }
21        }
22    }
23}