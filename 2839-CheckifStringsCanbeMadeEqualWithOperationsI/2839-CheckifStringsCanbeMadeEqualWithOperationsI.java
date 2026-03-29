// Last updated: 3/29/2026, 11:56:28 AM
1class Solution {
2    public boolean canBeEqual(String s1, String s2) {
3        char[] even1 = new char[2], odd1 = new char[2];
4        char[] even2 = new char[2], odd2 = new char[2];
5
6        int ev= 0, od = 0;
7
8        for(int i=0; i<4; i++){
9            if(i%2 == 0){
10                even1[ev] = s1.charAt(i);
11                even2[ev] = s2.charAt(i);
12                ev++;
13            }else{
14                odd1[od] = s1.charAt(i);
15                odd2[od] = s2.charAt(i);
16                od++;
17            }
18        }
19        Arrays.sort(even1);
20        Arrays.sort(even2);
21        Arrays.sort(odd1);
22        Arrays.sort(odd2);
23
24        return Arrays.equals(even1, even2) && Arrays.equals(odd1,odd2);
25
26    }
27}