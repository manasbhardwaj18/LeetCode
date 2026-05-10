// Last updated: 5/10/2026, 12:59:18 PM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char miss = 0; 
4        int len = t.length();
5
6        for(int i = 0; i < len; i++) {  
7            if(i < s.length()) {  
8                miss ^= s.charAt(i);  
9            }
10            miss ^= t.charAt(i);  
11        }
12        return miss; 
13    }
14}