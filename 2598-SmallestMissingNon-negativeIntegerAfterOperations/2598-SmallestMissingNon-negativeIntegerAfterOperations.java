// Last updated: 10/17/2025, 9:15:00 PM
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int result = 0;
        int[] rem = new int[value];
        for(int x : nums){
            int r = ( (x % value ) + value ) % value;
            rem[r]++;
        }
       while( rem [result % value] > 0){
        rem[result%value]--;
        result++;
       }
       return result;
    }
}