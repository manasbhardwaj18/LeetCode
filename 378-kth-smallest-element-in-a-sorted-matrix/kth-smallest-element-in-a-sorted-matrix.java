class Solution {

    private int rank(int[][] matrix, int mid){
        int n = matrix.length;
        int i=0, j=n-1, count =0;
        while(j>=0 && i<n){
            if(matrix[j][i] <= mid){
                count += (j+1);
                i++;
            }else{
                j--;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];

        while(left < right){
            int mid = left+(right - left)/2;
            int position = rank(matrix, mid);

            if(position < k){
                left = mid+1;
            } else{
                right = mid;
            }
        }

        return left;
    }
}