// Last updated: 5/10/2026, 12:59:57 PM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        int sumS = 0, sumT = 0;
4        for (char c : s.toCharArray()) {
5            sumS += c;
6        }
7
8        for (char c : t.toCharArray()) {
9            sumT += c;
10        }
11        return (char)(sumT - sumS);
12    }
13}