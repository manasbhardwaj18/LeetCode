// Last updated: 11/8/2025, 6:07:22 PM
public class Solution {
    public int minimumOneBitOperations(int n) {
        int ans = 0, f = 0;
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                if (f == 0) {
                    ans = ans + ((1 << (i + 1))) - 1;
                    f = 1;
                } else {
                    ans = ans - ((1 << (i + 1)) - 1);
                    f = 0;
                }
                System.out.println(ans);
            }
        }
        return ans;
    }
}