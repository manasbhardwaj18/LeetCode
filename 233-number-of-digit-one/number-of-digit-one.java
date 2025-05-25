class Solution {
    public int countDigitOne(int n) {
        int count=0;
        while(n>9){
            int digit_count=(int) Math.log10(n);
           
            int preceeding_decimal=(int)Math.pow(10.0,digit_count*1.0);
            
            int leading_digit=n/preceeding_decimal;
            count+=((leading_digit)*(Math.pow(10.0,digit_count-1))*digit_count);
           
            if(leading_digit>1)
            count+=preceeding_decimal;
            if(leading_digit==1){
                count+=((n%preceeding_decimal)+1);
            }
            n=n%preceeding_decimal;
          
        }
        return n==0 ? count : count+1;
    }
}