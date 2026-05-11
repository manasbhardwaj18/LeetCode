// Last updated: 5/11/2026, 5:56:12 PM
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if(s.length() != t.length()){
4            return false;
5        }
6
7        HashMap<Character, Integer> sCnt = new HashMap<>();
8        HashMap<Character, Integer> tCnt = new HashMap<>();
9
10        for(int i=0; i<s.length(); i++){
11            sCnt.put(s.charAt(i), 1 + sCnt.getOrDefault(s.charAt(i),0));
12            tCnt.put(t.charAt(i), 1 + tCnt.getOrDefault(t.charAt(i),0));
13        }
14        return sCnt.equals(tCnt);
15    }
16}