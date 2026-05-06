// Last updated: 5/6/2026, 7:56:26 AM
1class Solution {
2    public char[][] rotateTheBox(char[][] boxGrid) {
3        int m = boxGrid.length;
4        int n = boxGrid[0].length;
5
6        for(int i=0; i<m; i++){     // simulating gravity
7            int empty = n-1;
8
9            for(int j = n-1; j>=0; j--){
10                if(boxGrid[i][j] == '*'){
11                    empty = j-1;
12                }else if(boxGrid[i][j] == '#'){
13                    char temp = boxGrid[i][j];
14                    boxGrid[i][j] = boxGrid[i][empty];
15                    boxGrid[i][empty] = temp;
16                    empty--;
17                }
18            }
19        }
20
21        char[][] res = new char[n][m];   // rotating matrix
22        for(int i=0; i<m; i++){
23            for(int j=0; j<n; j++){
24                res[j][m-1-i] = boxGrid[i][j];
25            }
26        }
27        return res;
28    }
29}