// Last updated: 11/8/2025, 6:07:03 PM
class Solution {
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        while (n > 0) {
            ans ^= n;   
            n >>= 1;    
        }
        return ans;    
    }
}