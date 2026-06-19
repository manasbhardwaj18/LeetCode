// Last updated: 6/19/2026, 2:18:39 PM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int n = gain.length;
4        int max = 0;
5
6        for(int i=0; i <= n; i++){
7            int num = 0;
8            for(int j=0; j<i; j++){
9                num += gain[j];
10            }
11            max = Math.max(max, num);
12        }
13        return max;
14    }
15}