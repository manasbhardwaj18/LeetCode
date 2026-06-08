// Last updated: 6/8/2026, 12:17:56 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length;
4        int res[] = new int[n];
5
6        int left = 0, right = n-1;
7        int i = 0, j = n-1;
8
9        while(i < n){
10            if(nums[i] < pivot){
11                res[left++] = nums[i];
12            }
13
14            if(nums[j] > pivot){
15                res[right--] = nums[j];
16            }
17            i++;
18            j--;
19        }
20        while(left <= right){
21            res[left++] = pivot;
22        }
23    return res;
24    }
25}