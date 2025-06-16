public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;

        for (int[] v : ops) {
            minX = Math.min(minX, v[0]);
            minY = Math.min(minY, v[1]);
        }

        return minX * minY;
    }
}