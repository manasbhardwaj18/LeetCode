// Last updated: 4/6/2026, 12:09:04 PM
1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        Set<String> s1 = new HashSet<>();
4        
5        for(int[] o : obstacles){
6            s1.add(o[0] + "," + o[1]);
7        }
8
9        int[][] directions = {
10            {0,1}, {1,0}, {0,-1}, {-1,0}
11        };
12
13        int x = 0, y=0;
14        int dir = 0;
15        int maxDist = 0;
16
17        for(int cmd : commands){
18            if(cmd == -1){
19                dir = (dir + 1) % 4;
20            }else if(cmd  == -2){
21                dir = (dir + 3) % 4;
22            }else{
23                while(cmd-->0){
24                    int nx = x + directions[dir][0];
25                    int ny = y + directions[dir][1];
26
27                    if(s1.contains(nx + "," + ny)) break;
28
29                    x = nx;
30                    y = ny;
31
32                    maxDist = Math.max(maxDist, x*x +y*y);
33                }
34            }
35        }
36        return maxDist;
37    }
38}