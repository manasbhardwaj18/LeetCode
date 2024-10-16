class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x>0 && x%10 == 0)){
            return false;
        }
        int revNum=0;
        for(; revNum < x ; x/=10){
            revNum = revNum*10 + x%10;
        }
        return x == revNum || x == revNum/10;
    }

}