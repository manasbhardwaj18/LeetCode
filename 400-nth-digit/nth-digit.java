class Solution {
    public int findNthDigit(int n) {
        long digitInNum = 1, start = 1, end = 9;

        
        while (n > digitInNum * end) {
            n -= digitInNum * end;  
            digitInNum++;            
            start *= 10;             
            end *= 10;             
        }

        long num = start + (n - 1) / digitInNum;  
        String numStr = Long.toString(num);      
        return numStr.charAt((n - 1) % (int) digitInNum) - '0';  
    }
}