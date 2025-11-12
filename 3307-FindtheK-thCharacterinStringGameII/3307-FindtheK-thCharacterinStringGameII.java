// Last updated: 11/12/2025, 3:27:32 PM
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0){
            return new int[0];
        }

        int x=0, y=0, rows = mat.length, columns = mat[0].length;
        int[] result = new int[rows * columns];
        
        for(int i=0; i<result.length; i++){
            result[i] = mat[x][y];

            if((x + y) % 2 == 0){ 
                if(y == columns - 1){
                    x++;
                } else if(x == 0){
                    y++;
                } else {
                    x--;
                    y++;
                }
            } else { 
                if(x == rows - 1){
                    y++;
                } else if(y == 0){
                    x++;
                } else {
                    x++;
                    y--;
                }
                
            }
        
        }
    return result;    
    }
    
}