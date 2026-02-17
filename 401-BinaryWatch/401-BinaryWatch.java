// Last updated: 2/18/2026, 2:35:56 AM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        List<String> result = new ArrayList<>();
4        for(int h = 0; h < 12 ; h++){
5            for(int m=0; m<60;m++){
6                int tot = Integer.bitCount(h) + Integer.bitCount(m);
7                if(tot == turnedOn){
8                    String time = h + ":" + (m < 10 ? "0" + m : m);
9                    result.add(time);
10                }
11            }
12        }
13        return result;
14    }
15}