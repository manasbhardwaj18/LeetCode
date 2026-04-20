// Last updated: 4/20/2026, 1:02:51 PM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int j = colors.length;
4
5        for(int i=0; i<j; i++){
6            if(colors[i] != colors[j-1] || colors[j-1-i] != colors[0]){
7                return j-1-i;
8            }
9        }
10        return 0;
11    }
12}