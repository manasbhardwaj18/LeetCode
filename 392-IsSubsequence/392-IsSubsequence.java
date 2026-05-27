// Last updated: 5/27/2026, 3:53:44 PM
1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int sp = 0, tp  = 0;
4
5        while(sp < s.length() && tp < t.length()){
6            if(s.charAt(sp) == t.charAt(tp)){
7                sp++;
8            }
9            tp++;
10        }
11        return sp == s.length();
12    }
13}