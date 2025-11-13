// Last updated: 11/13/2025, 1:38:34 PM
class Solution {
    public int maxOperations(String s) {
        int res = 0, ones = 0, n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
            else if(i>0 && s.charAt(i-1) == '1'){
                res += ones;
            } 
        }
        return res;
    }
}