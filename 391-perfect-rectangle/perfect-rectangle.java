class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        TreeSet<int[]> set = new TreeSet<int[]>((a, b) -> {
            if (a[3] <= b[1]) return -1;
            else if (a[1] >= b[3]) return 1;
            else if (a[2] <= b[0]) return -1;
            else if (a[0] >= b[2]) return 1;
            else return 0;
        });
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
        int totalArea = 0;
        for (int[] i : rectangles) {
            if (i[0] < minX) {
                minX = i[0];
            } if (i[1] < minY) {
                minY = i[1];
            } if (i[2] > maxA) {
                maxA = i[2];
            } if (i[3] > maxB) {
                maxB = i[3];
            }
            totalArea += (i[2] - i[0]) * (i[3] - i[1]);
            if (!set.add(i)) return false;
        }
        return totalArea == (maxA - minX) * (maxB - minY);
    }
}