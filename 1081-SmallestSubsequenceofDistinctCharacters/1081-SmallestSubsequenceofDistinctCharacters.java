// Last updated: 7/19/2026, 3:50:25 PM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] last = new int[26];
4
5        for (int i = 0; i < s.length(); i++)
6            last[s.charAt(i) - 'a'] = i;
7
8        boolean[] inStack = new boolean[26];
9        StringBuilder st = new StringBuilder();
10
11        for (int i = 0; i < s.length(); i++) {
12            char ch = s.charAt(i);
13
14            if (inStack[ch - 'a'])
15                continue;
16
17            while (st.length() > 0 && st.charAt(st.length() - 1) > ch && last[st.charAt(st.length() - 1) - 'a'] > i) {
18                inStack[st.charAt(st.length() - 1) - 'a'] = false;
19                st.deleteCharAt(st.length() - 1);
20            }
21
22            st.append(ch);
23            inStack[ch - 'a'] = true;
24        }
25
26        return st.toString();
27    }
28}