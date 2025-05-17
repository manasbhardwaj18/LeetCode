class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static int N;
    private static int M;
    public char[][] updateBoard(char[][] board, int[] click) {
        N = board.length;
        M = board[0].length;
        dfs(board, click[0], click[1]);

        return board;
    }

    private void dfs(char[][] board, int r, int c){
        if (r < 0 || r >= N || c < 0 || c >= M || board[r][c] == 'B') return; 
        if (board[r][c] == 'M'){board[r][c] = 'X'; return;} 
        int mine = countMine(board, r, c);
        if (mine > 0) {board[r][c] = (char)('0' + mine); return;} 

        board[r][c] = 'B'; 
        for (int[] d : DIRS) dfs(board, r + d[0], c + d[1]);
    }

    private static int countMine(char[][] board, int r, int c){ 
        int count = 0;
        for (int[] d : DIRS){
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (board[nr][nc] == 'M') count++;
        }

        return count;
    }
}