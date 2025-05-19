class Solution{
public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int dis = getDistance(points, i, j);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int value : map.values()) {
                count += value * (value - 1);
            }

            map.clear();
        }

        return count;
    }

    public static int getDistance(int[][] points, int i, int j) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];

        return x * x + y * y;
    }
}    