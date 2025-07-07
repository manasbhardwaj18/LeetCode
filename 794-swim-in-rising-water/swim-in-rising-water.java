class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int start=grid[0][0];
        int end = (grid.length * grid.length)-1;
        int ans=grid[0][0];
        while(start<=end){
            int mid = (start + end)/2;
            if(isReachable(grid,mid)){
                ans=mid;
                end=mid-1;
            }
            else start = mid + 1;
        }
    return ans;
    }
    public boolean isReachable(int[][] nums, int target){
        int n =nums.length;
        boolean ans = false;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                Pair temp = q.poll();
                int r = temp.r;
                int c = temp.c;
                if(r==n-1 && c==n-1){
                    ans=true;
                    break;
                }
                for(int j=0;j<4;j++){
                    int newRow = r + row[j];
                    int newCol = c + col[j];
                    if(newRow >=0 && newRow<n && newCol>=0 && newCol<n && !visited[newRow][newCol] && nums[newRow][newCol]<=target){
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
    return ans;
    }
}