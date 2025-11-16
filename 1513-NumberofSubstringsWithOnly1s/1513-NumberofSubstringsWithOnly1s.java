// Last updated: 11/16/2025, 1:55:41 PM
class Solution {
    public int numSub(String s) {
        long res= 0,MOD = (long)Math.pow(10,9) + 7;
        int i = 0;
        while(i < s.length()){
            long len = 0;
            while(i < s.length() && s.charAt(i) == '1'){
                i++;
                len++;
            }
            i++;
            res += (long) (len * (len+1)) / 2;
            res %= MOD;
        }
        return (int)res;
    }
}