// Last updated: 3/9/2026, 2:01:22 PM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int n = nums.length;
4        char[] res = new char[n];
5
6        for(int i=0; i<n; i++){
7            res[i] = nums[i].charAt(i) == '0' ? '1' : '0';
8        }
9        return new String(res);
10    }
11}