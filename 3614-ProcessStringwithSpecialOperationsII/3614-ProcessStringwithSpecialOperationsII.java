// Last updated: 6/17/2026, 1:10:05 PM
1class Solution {
2    public char processStr(String s, long k) {
3        long len = 0;
4
5        for (char c : s.toCharArray()) {
6            if (c == '*') len = Math.max(0, len - 1);
7            else if (c == '#') len *= 2;
8            else if (c != '%') len++;
9        }
10
11        if (k >= len) return '.';
12
13        for (int i = s.length() - 1; i >= 0; i--) {
14            char c = s.charAt(i);
15            if (c == '*') len++;
16            else if (c == '#') {
17                long half = len / 2;
18                if (k >= half) k -= half;
19                len = half;
20            }
21            else if (c == '%') {
22                k = len - 1 - k;
23            }
24            else {
25                if (k == len - 1) return c;
26                len--;
27            }
28        }
29        return '.';
30    }
31}