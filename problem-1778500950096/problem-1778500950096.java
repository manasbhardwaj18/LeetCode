// Last updated: 5/11/2026, 5:32:30 PM
1class Solution {
2    public int strStr(String haystack, String needle) {
3        if(haystack.length() < needle.length()){
4            return -1;
5        }
6
7        for(int i=0; i <= haystack.length() - needle.length(); i++){
8            if(haystack.substring(i, i + needle.length()).equals(needle)){
9                return i;
10            }
11        }
12        return -1;
13
14    }
15}