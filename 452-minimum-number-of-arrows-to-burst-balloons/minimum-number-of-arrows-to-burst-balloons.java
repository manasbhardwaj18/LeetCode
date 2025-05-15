class Solution {
    public int findMinArrowShots(int[][] arr) {
        int n = arr.length; 
        int arrow = 1; 
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1; i < n; i++)
        {
            if(arr[i][0] > end) 
            {
          
                start = arr[i][0];
                end = arr[i][1];
                
                arrow++; 
            }
            else 
            {
                start = Math.max(start, arr[i][0]);
                end = Math.min(end, arr[i][1]);
            }
        }
        return arrow;
        
    }
    
}