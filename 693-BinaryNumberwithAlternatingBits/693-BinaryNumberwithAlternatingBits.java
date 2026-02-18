// Last updated: 2/18/2026, 1:49:35 PM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int res = n ^ ( n >> 1);
4        return (res & (res + 1)) == 0;
5    }
6}