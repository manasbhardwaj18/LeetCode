// Last updated: 5/10/2026, 11:52:41 AM
1class Solution {
2    public String mergeAlternately(String word1, String word2) {
3        StringBuilder res = new StringBuilder();
4        int maxL = Math.max(word1.length(), word2.length());
5
6        for(int i=0; i < maxL; i++){
7            if(i < word1.length()){
8                res.append(word1.charAt(i));
9            }
10            if(i < word2.length()){
11                res.append(word2.charAt(i));
12            }
13        }
14        return res.toString();
15    }
16}