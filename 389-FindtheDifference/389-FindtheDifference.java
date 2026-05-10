// Last updated: 5/10/2026, 1:01:02 PM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        int sumA = 0, sumB = 0;
4
5        for(char c : s.toCharArray()){
6            sumA += c;
7        }
8
9        for(char c : t.toCharArray()){
10            sumB += c;
11        }
12        return (char) (sumB - sumA);
13    }
14}