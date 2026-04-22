// Last updated: 4/22/2026, 9:23:39 PM
1class Solution {
2    boolean hasMatch(String query, String[] dictionary){
3        boolean found = false;
4        for(String dict : dictionary){
5            int diffMax = 2;
6            for(int i=0; i<dict.length(); i++){
7                if(dict.charAt(i) != query.charAt(i)){
8                    diffMax--;
9                }
10                if(diffMax < 0){
11                    break;
12                }
13            }
14            if(diffMax >= 0){
15                return true;
16            }
17        }
18        return found;
19    }
20    public List<String> twoEditWords(String[] queries, String[] dictionary) {
21        List<String> result = new ArrayList<>();
22        for(String query : queries){
23            if(hasMatch(query, dictionary)){
24                result.add(query);
25            }
26        }
27        return result;
28    }
29}