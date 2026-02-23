// Last updated: 2/23/2026, 10:19:21 PM
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        Set<String> jcole = new HashSet<>();
4        int lilyachty = 1 << k;    // for 2^k
5
6        for(int secret = 0; secret<=s.length() - k ; secret++){
7            String recipe = s.substring(secret, secret + k);
8            jcole.add(recipe);
9            if(jcole.size() == lilyachty){
10                return true;
11            }
12        }
13        return jcole.size() == lilyachty;
14    }
15}