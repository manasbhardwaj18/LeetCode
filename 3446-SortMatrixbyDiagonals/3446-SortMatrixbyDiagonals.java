// Last updated: 8/28/2025, 1:22:05 PM
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int k = 0; k < 2*n-1; k++){
            int i = k < n ? 0 : k-n+1;
            int j = k < n ? k : 0;

            int ti = i;
            int tj = j;
            while(ti < n && tj < n){
                arr.add(grid[ti++][tj++]);
            }

            if(k < n-1 && k != 0){
                Collections.sort(arr);
            }
            else{
                Collections.sort(arr, Collections.reverseOrder());
            }

            for(int ele : arr){
                grid[i++][j++] = ele;
            }
            arr.clear();
        }

        return grid;
    }
}