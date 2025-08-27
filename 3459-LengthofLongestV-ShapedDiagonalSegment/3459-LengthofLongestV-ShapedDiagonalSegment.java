// Last updated: 8/27/2025, 1:23:55 PM
class Solution {
    int m = 0;
    int n = 0;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int temp = explore(i,j,grid,0,0,true);
                    res = Math.max(temp,res);
                }
            }
        }
        return res;
    }

    public boolean inRange(int i,int j){
        return i<m && j<n && i>=0 && j>=0;
    }

    public int explore(int i,int j,int[][] grid,int x,int y,boolean turn){
        if(grid[i][j] == 1){
            
            int A = 0;
            int B = 0;
            int C = 0;
            int D = 0;

            if(inRange(i+1,j+1) && grid[i+1][j+1] == 2)
                A = explore(i+1,j+1,grid,1,1,turn);

            if(inRange(i-1,j+1)  && grid[i-1][j+1] == 2)
                B = explore(i-1,j+1,grid,-1,1,turn);

            if(inRange(i+1,j-1)  && grid[i+1][j-1] == 2)
                C = explore(i+1,j-1,grid,1,-1,turn);

            if(inRange(i-1,j-1)  && grid[i-1][j-1] == 2)
                D = explore(i-1,j-1,grid,-1,-1,turn);
            
            return 1 + Math.max(Math.max(A,B),Math.max(C,D));
        }
        
        int find = grid[i][j] == 2 ? 0 : 2;
           
            int Tx = 0;
            int Ty = 0;
            int A = 0;

            if(turn){
                if((x == 1 && y == 1) || (x == -1 && y == -1)){
                    int yt = -y;
                    if(inRange(i+x,j+yt)  && grid[i+x][j+yt] == find)
                        Ty = explore(i+x,j+yt,grid,x,yt,false);
                }else{
                    int xt = -x;
                    if(inRange(i+xt,j+y)  && grid[i+xt][j+y] == find)
                        Tx = explore(i+xt,j+y,grid,xt,y,false);
                }
            }

            if(inRange(i+x,j+y)  && grid[i+x][j+y] == find)
                A = explore(i+x,j+y,grid,x,y,turn);
            
            return 1 + Math.max(A,Math.max(Tx,Ty));
    }
}