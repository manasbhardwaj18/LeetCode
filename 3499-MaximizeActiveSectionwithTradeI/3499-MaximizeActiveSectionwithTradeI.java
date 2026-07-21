// Last updated: 7/21/2026, 9:47:33 AM
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        int ones = 0;
4        for (char c : s.toCharArray())
5            if (c == '1')
6                ones++;
7
8        s = "1" + s + "1";
9
10        int n = s.length();
11        int i = 0;
12
13        int ans = ones;
14
15        while (i < n && s.charAt(i) == '1')
16            i++;
17
18        int c10 = 0;
19        while (i < n && s.charAt(i) == '0') {
20            c10++;
21            i++;
22        }
23
24        while (i < n) {
25            int c11 = 0;
26            while (i < n && s.charAt(i) == '1') {
27                c11++;
28                i++;
29            }
30
31            if (c11 == 0)
32                break;
33            int c20 = 0;
34            while (i < n && s.charAt(i) == '0') {
35                c20++;
36                i++;
37            }
38
39            if (c20 == 0)
40                break;
41
42            ans = Math.max(ans, ones + c10 + c20);
43            c10 = c20;
44        }
45
46        return ans;
47    }
48}