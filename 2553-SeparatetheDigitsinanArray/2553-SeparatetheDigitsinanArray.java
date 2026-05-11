// Last updated: 5/11/2026, 9:18:54 AM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        List<Integer> l1 = new ArrayList<>();
4
5        for(int num : nums){
6            String s = String.valueOf(num);
7            for(char ch : s.toCharArray()){
8                l1.add(ch - '0');
9            }
10        }
11
12        int[] res = new int[l1.size()];
13
14        for(int i=0; i < l1.size(); i++){
15            res[i] = l1.get(i);
16        }
17        return res;
18    }
19}