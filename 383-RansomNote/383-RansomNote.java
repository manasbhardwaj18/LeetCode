// Last updated: 5/27/2026, 4:05:15 PM
1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        HashMap<Character, Integer> ct = new HashMap<>();
4
5        for(char c : magazine.toCharArray()){
6            ct.put(c, ct.getOrDefault(c,0) + 1);
7        }
8        for(char c : ransomNote.toCharArray()){
9            if(!ct.containsKey(c) || ct.get(c) <= 0){
10                return false;
11            }
12            ct.put(c, ct.get(c) - 1);
13        }
14        return true;
15    }
16}