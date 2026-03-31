// Last updated: 3/31/2026, 12:15:59 PM
1class Solution {
2    public String generateString(String str1, String str2) {
3        int m = str1.length(), n =str2.length();
4        char[] s1 = new char[m+n-1];
5        int[] fix = new int[m+n-1];
6
7        for(int i=0; i<s1.length; i++){
8            s1[i] = 'a';
9        }
10        for(int i=0; i<m; i++){
11            if(str1.charAt(i) == 'T'){
12                for(int j=i; j<i+n; j++){
13                    if(fix[j] == 1 && s1[j] != str2.charAt(j-i)){
14                        return "";
15                    }else{
16                        s1[j] = str2.charAt(j-i);
17                        fix[j] = 1;
18                    }
19                }
20            }
21        }
22        for(int i=0; i<m; i++){
23            if(str1.charAt(i) == 'F'){
24                boolean flag = false;
25                int idx= -1;
26                for(int j=i+n-1; j>=i; j--){
27                    if(str2.charAt(j-i) != s1[j]) {
28                        flag = true;
29                    }
30                    if(idx == -1 && fix[j] == 0){
31                        idx = j;
32                    }
33                }
34                if(flag){
35                    continue;
36                }else if(idx != -1){
37                    s1[idx] = 'b';
38                }else{
39                    return "";
40                }
41            }
42        }
43
44        return new String(s1);
45    }
46}