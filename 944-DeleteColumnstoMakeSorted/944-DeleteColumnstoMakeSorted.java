// Last updated: 12/20/2025, 2:02:01 PM
1class Solution {
2
3    public boolean isSorted(int col, String[] strs){
4        for(int m=1;m<strs.length;m++){
5            if(strs[m].charAt(col) < strs[m-1].charAt(col)){
6                return false;
7            }
8        }
9        return true;
10    }
11    public int minDeletionSize(String[] strs) {
12        int count=0;
13        for(int i=0;i<strs[0].length();i++){
14            if(!isSorted(i,strs)){
15                count++;
16            }
17        }
18        return count;
19    }
20}