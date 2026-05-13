// Last updated: 5/13/2026, 12:47:10 PM
1class Solution {
2    public boolean repeatedSubstringPattern(String s) {
3        int n = s.length();
4
5        String sFold = s.substring(1, n) + s.substring(0, n-1);
6        return sFold.contains(s);
7    }
8}