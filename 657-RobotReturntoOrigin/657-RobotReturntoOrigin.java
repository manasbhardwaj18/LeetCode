// Last updated: 9/21/2025, 9:23:50 PM
class Solution {
    public boolean judgeCircle(String move) {
        int l=0, r=0, u=0, d=0;
        
        for(int i=0;i<move.length();i++){
            if(move.charAt(i)=='L')
               l++;
            else if(move.charAt(i)=='R')
               r++;  
            else if(move.charAt(i)=='U')
               u++; 
            else
               d++;
        }
        if(u==d&&l==r)
           return true;
        return false;
    }
}