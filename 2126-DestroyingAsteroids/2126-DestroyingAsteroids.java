// Last updated: 5/31/2026, 9:06:18 AM
1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4        long current = mass;
5
6        for(int ast : asteroids){
7            if(current < ast){
8                return false;
9            }
10            current += ast;
11        }
12        return true;
13    }
14}