// Last updated: 8/26/2025, 1:43:50 PM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int num=low;num <=high;num++){
            String str = Integer.toString(num);
            int len = str.length();
            if(len%2==0){
                int a = len/2;
                int lsum = 0;
                 int rsum = 0;
                for(int i = 0;i<a;i++){
                    lsum += str.charAt(i) - '0';
                }
                for(int i=a;i<len;i++){
                    rsum += str.charAt(i) - '0';
                }
                if(lsum == rsum){
                    count++;
                }
            }
        }
        return count;
    }
}