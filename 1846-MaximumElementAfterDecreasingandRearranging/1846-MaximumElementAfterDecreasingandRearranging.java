// Last updated: 6/29/2026, 1:22:07 AM
1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        Arrays.sort(arr);
4        arr[0] = 1;
5        for(int i=1; i < arr.length; i++){
6            arr[i] = Math.min(arr[i], arr[i-1] + 1);
7        }
8        return arr[arr.length - 1];
9    }
10}