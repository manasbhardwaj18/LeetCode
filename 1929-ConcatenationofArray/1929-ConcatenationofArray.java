// Last updated: 5/10/2026, 1:27:06 PM
1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int max=0, count = 0;
4        for(int num : nums){
5            if(num == 1){
6                count++;
7                if(count > max){
8                    max = count;
9                }
10            }else{
11                count = 0;
12            }
13        }
14        return max;
15    }
16}