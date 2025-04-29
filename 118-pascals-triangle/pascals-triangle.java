class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows >= 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);
        }

        for (int row = 1; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            
            for (int j = 1; j < row; j++) {
                int value = triangle.get(row - 1).get(j - 1) + triangle.get(row - 1).get(j);
                currentRow.add(value);
            }
            
            currentRow.add(1);
            triangle.add(currentRow);
        }
        
        return triangle;
    }
}
