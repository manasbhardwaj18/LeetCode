// Last updated: 9/3/2025, 3:02:12 PM
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; 
            }
            return a[0] - b[0]; 
        });
        int result = 0;
        for (int i = 0; i < n; i++) {
            int aliceX = points[i][0];
            int aliceY = points[i][1]; 
            int bestBobY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int bobX = points[j][0];
                int bobY = points[j][1]; 

                if(bobY > aliceY){
                    continue;
                }

                if(bobY > bestBobY){
                    result++;
                    bestBobY = bobY;
                }
            }
        }
        return result;
    }
}