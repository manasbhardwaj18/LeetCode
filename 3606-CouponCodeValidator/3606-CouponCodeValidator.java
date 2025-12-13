// Last updated: 12/13/2025, 1:50:35 PM
1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3        List<String> ans = new ArrayList<>();
4        List<Integer> val = new ArrayList<>();
5        Set<String> valBus = new HashSet<>();
6        valBus.add("electronics");
7        valBus.add("grocery");
8        valBus.add("pharmacy");
9        valBus.add("restaurant");
10
11        for(int i =0;i<code.length;i++){
12            if(!isActive[i] || code[i].equals("") || !isAlphaNumeric(code[i])){
13                continue;
14            }
15            if(!valBus.contains(businessLine[i])){
16                continue;
17            }
18            val.add(i);
19        }
20
21        Collections.sort(val,(a,b) -> {
22            if(!businessLine[a].equals(businessLine[b])){
23                return businessLine[a].compareTo(businessLine[b]);
24            }
25            return code[a].compareTo(code[b]);
26        });
27
28        for(int idx : val){
29            ans.add(code[idx]);
30        }
31        return ans;
32    }
33
34    boolean isAlphaNumeric(String business){
35        for(int i=0;i<business.length();i++){
36            char ch = business.charAt(i);
37            if(!Character.isLetterOrDigit(ch) && ch != '_'){
38                return false;
39            }
40        }
41            return true;
42        }
43    
44}