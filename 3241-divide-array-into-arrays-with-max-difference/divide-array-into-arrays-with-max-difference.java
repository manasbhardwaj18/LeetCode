class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int [][]grid=new int [n/3][3];
        
        Arrays.sort(nums);
        
        int v=0;

        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]=nums[v++];
            }
        }

        for(int i=0;i<n/3;i++){
            int x=grid[i][0],y=grid[i][1],z=grid[i][2];
            if((z-x)>k){
                return new int[0][0];
            }
        }
        return grid;
    }
}