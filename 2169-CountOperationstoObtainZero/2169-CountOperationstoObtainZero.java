// Last updated: 11/9/2025, 12:24:37 PM
class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;
        if(num1== 0 || num2 ==0){ return 0;}
        while(num1 != num2){
            if(num1>=num2){
                num1-=num2;
                count++;
            }else{
                num2-=num1;
                count++;
            }
        }
        return count+1;
    }
}