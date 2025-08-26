// Last updated: 8/26/2025, 1:35:45 PM
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea=0;
        int maxDia=0;
        int n=dimensions.length;
        for(int i=0; i<n; i++) {
            int l=dimensions[i][0];
            int b=dimensions[i][1];

            int currDia=l*l+b*b;
            int currArea=l*b;

            if(currDia>maxDia || (currDia==maxDia && currArea>maxArea)) {
                maxArea=currArea;
                maxDia=currDia;
            }
        }

        return maxArea;
    }
}