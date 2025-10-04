// Last updated: 10/4/2025, 11:34:13 AM
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0;
        while(left<right){
            maxArea = Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}