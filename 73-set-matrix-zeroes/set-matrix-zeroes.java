class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeroPos = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> dummy = Arrays.asList(i, j);
                    zeroPos.add(dummy);
                }
            }
        }

        int sol = zeroPos.size();
        int start, end;

        for (int i = 0;i<sol;i++) {
            start = zeroPos.get(i).get(0);
            end = zeroPos.get(i).get(1);
            MakeRowZeroes(matrix[start],n);
            MakeColumnZeroes(matrix,m,end);
        }
    }

    void MakeRowZeroes(int[] arr,int n) {
        for (int i = 0;i<n;i++) {
            arr[i] = 0;
        }
    }

    void MakeColumnZeroes(int[][] arr,int m,int index) {
        for (int i = 0;i < m;i++) {
            arr[i][index] = 0;
        }
    }
}