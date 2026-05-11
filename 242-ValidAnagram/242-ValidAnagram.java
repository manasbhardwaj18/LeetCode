// Last updated: 5/11/2026, 5:47:38 PM
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if(s.length() != t.length()){
4            return false;
5        }
6
7        int[] cnt = new int[26];
8
9        for(int i=0; i<s.length(); i++){
10            cnt[s.charAt(i) - 'a'] += 1;
11        }
12
13        for(int i=0; i<s.length(); i++){
14            if(cnt[t.charAt(i) - 'a'] == 0){
15                return false;
16            }
17            cnt[t.charAt(i) - 'a'] -= 1;
18        }
19        return true;
20    }
21}