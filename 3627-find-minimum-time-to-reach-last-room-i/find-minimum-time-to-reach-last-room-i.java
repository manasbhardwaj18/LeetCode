class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i == m - 1 && j == n - 1) {
                return currTime;
            }

            for (int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n) {
                    int wait = Math.max(moveTime[i_][j_] - currTime, 0);
                    int arrTime = currTime + wait + 1;

                    if (result[i_][j_] > arrTime) {
                        result[i_][j_] = arrTime;
                        pq.offer(new int[]{arrTime, i_, j_});
                    }
                }
            }
        }

        return -1;
    }
}