// Last updated: 5/27/2026, 11:16:53 AM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int[] lastL = new int[26];
4        int[] firstU = new int[26];
5
6        Arrays.fill(lastL, -1);
7        Arrays.fill(firstU, -1);
8
9        HashSet<Integer> inv = new HashSet<>();
10
11        for(int i=0; i<word.length(); i++){
12            char ch = word.charAt(i);
13
14            if(ch >= 'a' && ch <= 'z'){
15                int idx = ch - 'a';
16
17                lastL[idx] = i;
18
19                if(firstU[idx] != -1){
20                    inv.add(idx);
21                }
22            }else{
23                int idx = ch - 'A';
24                if(firstU[idx] == -1){
25                    firstU[idx] = i;
26                }
27            }
28        } 
29        int special = 0;
30        for(int i=0; i< 26; i++){
31            if(lastL[i] != -1 && firstU[i] != -1 && !inv.contains(i)){
32                special++;
33            }
34        }
35        return special;
36    }
37}