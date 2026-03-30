// Last updated: 3/30/2026, 12:45:13 PM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] freq = new int[52];
4
5        for(int i=0; i<s1.length(); i++){
6            int a = (i & 1)*26;
7            freq[s1.charAt(i) - 'a' + a]++;
8            freq[s2.charAt(i) - 'a' + a]--;
9        }
10
11        for(int i=0; i < 52; i++){
12            if(freq[i] != 0){
13                return false;
14            }
15        }
16
17        return true;
18    }
19}