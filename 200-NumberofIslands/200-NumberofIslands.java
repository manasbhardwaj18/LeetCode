// Last updated: 10/9/2025, 3:59:18 PM
class Solution {
    private static void dfs(int i,int j,int m,int n,char[][] grid)
    {
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(grid[i][j]=='1'){
        grid[i][j]='#';
        

        dfs(i-1,j,m,n,grid);
        dfs(i,j-1,m,n,grid);
        dfs(i+1,j,m,n,grid);
        dfs(i,j+1,m,n,grid);
        }
        else return;
    }
    public int numIslands(char[][] grid) {
        int ans =0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,m,n,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
}