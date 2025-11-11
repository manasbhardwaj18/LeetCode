// Last updated: 11/11/2025, 7:27:35 PM
class Solution {
    public int maxDifference(String s) {
        char [] chars = s.toCharArray();
        Arrays.sort(chars);
        int maxOdd = 0, minEven = Integer.MAX_VALUE;
        char current = chars[0];
        int count = 1;

        for(int i = 1; i<chars.length;i++){
            if(chars[i] == current){
                count++;
            }else{
                if((count & 1) == 1){
                    maxOdd = Math.max(maxOdd,count);
                }else{
                    minEven = Math.min(minEven,count);
                }
                current = chars[i];
                count = 1;
            }
        }
        if((count & 1) == 1){
            maxOdd = Math.max(maxOdd,count);
        }else{
            minEven = Math.min(minEven,count); 
        }
        return maxOdd - minEven;
    }
}