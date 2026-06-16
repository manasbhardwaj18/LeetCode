// Last updated: 6/16/2026, 11:45:31 AM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4        int n = s.length();
5
6        for(int i=0; i< n; i++){
7            char ch = s.charAt(i);
8
9            if(ch == '*'){
10                if(sb.length() != 0){
11                    sb.deleteCharAt(sb.length()-1);
12                }
13            }else if( ch == '#'){
14                sb.append(sb);
15            }else if(ch == '%'){
16                sb.reverse();
17            }else if(ch >= 'a' && ch <= 'z'){
18                sb.append(ch);
19            }
20        }
21        return sb.toString();
22    }
23}