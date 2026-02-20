// Last updated: 2/20/2026, 10:07:58 PM
1class Solution {
2    public String makeLargestSpecial(String s) {
3        int count = 0, i=0;
4        List<String> res = new ArrayList<>();
5
6        for(int j=0; j<s.length(); j++){
7            if(s.charAt(j) == '1'){
8                count++;
9            }else{
10                count--;
11            }
12
13            if(count == 0){
14                res.add('1' + makeLargestSpecial(s.substring(i+1, j)) + '0');
15                i= j+1;
16            }
17        }
18        Collections.sort(res, Collections.reverseOrder());
19        return String.join("", res);
20    }
21
22}