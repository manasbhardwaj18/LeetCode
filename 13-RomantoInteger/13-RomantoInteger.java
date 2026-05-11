// Last updated: 5/11/2026, 5:23:56 PM
1class Solution {
2    public int romanToInt(String s) {
3        Map<Character, Integer> mp = new HashMap<>();
4        mp.put('I', 1);
5        mp.put('V', 5);
6        mp.put('X', 10);
7        mp.put('L', 50);
8        mp.put('C', 100);
9        mp.put('D', 500);
10        mp.put('M', 1000);
11        
12        int ans = 0;
13        int n = s.length();
14        
15        for (int i = 0; i < n; i++) {
16            if (i < n - 1 && mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
17                ans += mp.get(s.charAt(i + 1)) - mp.get(s.charAt(i));
18                i++;
19            } else {
20                ans += mp.get(s.charAt(i));
21            }
22        }
23        
24        return ans;
25    }
26}