// Last updated: 4/18/2026, 12:03:09 PM
1class Solution {
2    public int mirrorDistance(int n) {
3        int rev= 0;
4        for(int a = n; a > 0; a/=10){
5            rev = 10*rev + a%10;
6        }
7        return Math.abs(rev-n);
8    }
9}