// Last updated: 9/5/2025, 12:48:14 PM
class Solution {
    public int makeTheIntegerZero(int n1, int n2) {
        for (int op = 1; op <= 60; op++) {
            long rem = 1L * n1 - 1L * op * n2;
            if (rem < op) continue;
            int pop = Long.bitCount(rem);
            if (pop <= op && op <= rem) return op;
        }
        return -1;
    }
}