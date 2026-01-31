// Last updated: 1/31/2026, 8:18:08 PM
1class Solution {
2    public String reverseByType(String s) {
3        char[] ar1 = s.toCharArray();
4        reverse(ar1, true);
5        reverse(ar1,false);
6        return new String(ar1);
7    }
8
9    void reverse(char[] ar1, boolean letters){
10        int i=0, j = ar1.length-1;
11        while(i<j){
12            boolean l1 = Character.isLowerCase(ar1[i]);
13            boolean l2 = Character.isLowerCase(ar1[j]);
14            if(l1 == letters && l2 == letters){
15                char t1 = ar1[i];
16                ar1[i++] = ar1[j];
17                ar1[j--] = t1;
18            }else{
19                if(l1 != letters){
20                    i++;
21                }
22                if(l2 != letters){
23                    j--;
24                }
25            }
26        }
27    }
28}