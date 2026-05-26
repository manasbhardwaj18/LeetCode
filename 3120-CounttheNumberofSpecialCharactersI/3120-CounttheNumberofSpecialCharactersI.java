// Last updated: 5/26/2026, 10:55:01 AM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        HashSet<Character> s1 = new HashSet<>();
4
5        for(char ch : word.toCharArray()){
6            s1.add(ch);
7        }
8        int count = 0;
9
10        for(char ch : s1){
11            if(Character.isUpperCase(ch) && s1.contains(Character.toLowerCase(ch))){
12                count++;
13            }
14        }
15        return count;
16    }
17}