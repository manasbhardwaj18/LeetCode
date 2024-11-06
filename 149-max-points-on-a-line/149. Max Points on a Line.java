class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;

        int maxPoints = 0;
        final int inf = 999999;

        for(int i=0; i<points.length; i++) {
            
            Map<Double, Integer> map = new HashMap<>(); 

            for(int j=i+1; j<points.length; j++) {
                double slope = 0;

                if(points[i][0] == points[j][0]) {  
                    slope = inf;
                } else {
                    slope = ((double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]));
                }
                
                if(slope == -0.0) slope = 0.0;
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, map.get(slope) + 1);
            }
        }
        return maxPoints;
    }
}