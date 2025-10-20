// Last updated: 10/20/2025, 2:09:53 PM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String op : operations){
            if(op.indexOf('+') != -1) x++;
            else x--;
        }
        return x;
    }
}