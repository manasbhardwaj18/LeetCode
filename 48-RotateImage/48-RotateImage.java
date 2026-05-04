// Last updated: 5/4/2026, 2:58:08 PM
class Solution {
    public void rotate(int[][] matrix) {
        //find transpose (diagonal from left to right)
        //reverse the matrix
        
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                //transpose
               swap(matrix,i,j);
            }
        }
        System.out.println(matrix);

        //reverse
        for(int i=0;i<m;i++){
           
           int left=0;
           int right=n-1;

           while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;

                left++;
                right--;
           }
        }
    }

    private void swap(int[][] matrix , int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    
}