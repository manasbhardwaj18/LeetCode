// Last updated: 4/15/2026, 1:05:55 PM
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length;
4        int ans = Integer.MAX_VALUE;
5
6        for(int a = 0; a < n; a++){
7            if(words[a].equals(target)){
8                int r = (a - startIndex + n) % n;
9                int l = (startIndex - a + n) % n;
10                ans  = Math.min(ans, Math.min(r, l));
11            }
12            
13        }
14        return ans == Integer.MAX_VALUE ? -1:ans;
15    }
16}