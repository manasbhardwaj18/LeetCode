// Last updated: 10/28/2025, 6:35:06 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int sum =0, left =0, cases=0;
        for(int num :nums){
            sum+=num;
        }
        for(int num: nums){
            int rt = sum - left - num;
            if(num == 0){
                if(left == rt){
                    cases += 2;
                }else if( left == rt - 1 || left - 1 == rt ){
                    cases += 1;
                }
            }
            left += num;
        }
        return cases;
    }
}