class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0;
        while(left<right){
            int h = Math.min(height[left],height[right]);
            int w = right-left;
            maxArea = Math.max(maxArea,h*w);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}