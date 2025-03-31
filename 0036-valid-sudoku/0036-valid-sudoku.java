class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num != '.'){
                    String rowVal = "row"+i+"-"+num;
                    String colVal = "col"+j+"-"+num;
                    String boxVal = "box"+(i/3)+"-"+(j/3)+"-"+num;

                    if(seen.contains(rowVal) || seen.contains(colVal) || seen.contains(boxVal)){
                        return false;
                    }
                    seen.add(rowVal);
                    seen.add(colVal);
                    seen.add(boxVal);
                }
            }
        }
        return true;
    }
}