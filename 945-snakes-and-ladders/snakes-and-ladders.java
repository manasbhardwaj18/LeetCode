class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cell = curr[0];
            int moves = curr[1];

            if (cell == n * n) {
                return moves;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cell + dice;
                if (next > n * n) break;

                int[] coords = getCoordinates(next, n);
                int row = coords[0], col = coords[1];

                int dest = board[row][col] == -1 ? next : board[row][col];
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.offer(new int[]{dest, moves + 1});
                }
            }
        }
        return -1;
    }

    private int[] getCoordinates(int cellNumber, int boardSize) {
        int r = (cellNumber - 1) / boardSize;
        int c = (cellNumber - 1) % boardSize;
        if (r % 2 == 1) {
            c = boardSize - 1 - c;
        }
        return new int[]{boardSize - 1 - r, c};
    }
}