// Last updated: 10/23/2025, 2:06:47 PM
class Solution {
    public boolean hasSameDigits(String s) {
        char[] fin = s.toCharArray();
        for (int i = fin.length - 1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                fin[j] = (char) ((fin[j] + fin[j + 1]) % 10 + '0');
            }
        }
        return fin[0] == fin[1];
    }
}