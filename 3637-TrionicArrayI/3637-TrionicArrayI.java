// Last updated: 2/3/2026, 11:54:03 AM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int len = nums.length;
4        if(len < 4){   // min req for condition (up - downn - up)
5            return false; 
6        }
7        int i = 0;
8        while(i+1 < len && nums[i] < nums[i+1]){
9            i++;
10        }
11        if(i==0 || i == len-1){
12            return false;
13        }
14        int p = i;
15        while(i+1 < len && nums[i] > nums[i+1]){
16            i++;
17        }
18        if(i==p || i== len-1) return false;
19        while(i+1 < len && nums[i] < nums[i+1]){
20            i++;
21        }
22        return i==len-1;
23    }
24}