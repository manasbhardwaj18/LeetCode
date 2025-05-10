class Solution {
    private void dfs(int r,int c,char[][] board,boolean[][] visited)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='X' || visited[r][c]) return;
        visited[r][c]=true;
        dfs(r-1,c,board,visited);
        dfs(r+1,c,board,visited);
        dfs(r,c+1,board,visited);
        dfs(r,c-1,board,visited);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<n;i++)
            if(board[0][i]=='O') 
            dfs(0,i,board,visited);

        for(int i=0;i<m;i++)
            if(board[i][0]=='O') 
            dfs(i,0,board,visited);

        for(int i=0;i<n;i++)
            if(board[m-1][i]=='O') 
            dfs(m-1,i,board,visited);

        for(int i=0;i<m;i++)
            if(board[i][n-1]=='O') 
            dfs(i,n-1,board,visited);

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && !visited[i][j])
                board[i][j] = 'X';
            }
        }
    }
}