// Last updated: 1/4/2026, 1:05:05 PM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int sum = 0;
4
5        for(int num : nums){
6            int num_div = 0;
7        
8            for(int div=2; div*div <= num; div++){
9                if(num % div == 0){
10                    if(num_div == 0){
11                        num_div = div;
12                    }else{
13                        num_div = 0;
14                        break;
15                    }
16                }
17            }
18
19            if(num_div > 0 && num_div != num/num_div){
20                sum += 1 + num + num_div + num/num_div;
21            }
22        }
23        return sum;
24    }
25}