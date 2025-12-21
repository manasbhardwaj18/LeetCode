// Last updated: 12/21/2025, 2:52:38 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3    int m = strs.length;
4    int n = strs[0].length();
5    boolean check[] = new boolean[m-1]; 
6                        
7    int count = 0; 
8    for(int col=0; col<n; col++){
9        boolean deletionNeeded = false;
10        for(int row = 1; row<m; row++){
11            if(check[row-1])
12            continue; 
13
14            if(strs[row].charAt(col) < strs[row-1].charAt(col)){   
15                deletionNeeded = true;
16                break;
17            }
18        }
19
20            if(deletionNeeded){
21                count++;
22            }else{
23                for(int row = 1; row<m; row++){
24                    if(!check[row-1] && strs[row].charAt(col) > strs[row-1].charAt(col))
25                    check[row-1] = true;   
26                    }
27            }
28        }
29        return count;
30    }  
31}
32