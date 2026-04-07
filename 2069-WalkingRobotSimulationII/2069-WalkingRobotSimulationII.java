// Last updated: 4/7/2026, 12:07:10 PM
1class Robot {
2
3    int w, h, x, y, dir, per;
4    
5    public Robot(int width, int height) {
6        this.w = width;
7        this.h = height;
8        this.x=0;
9        this.y = 0;
10        this.dir = 0;
11        this.per = 2*(w+h)- 4;
12    }
13    
14    public void step(int num) {
15        if(per == 0) return;
16
17        num %= per;
18
19        if(num == 0){
20            if(x == 0 && y== 0){
21                dir = 3;
22            }
23            return;
24        }
25
26        while(num > 0){
27            if(dir == 0){
28                int move = Math.min(num, w-1-x);
29                x += move;
30                num -= move;
31                if(num > 0) dir = 1;
32            }
33            else if(dir == 1){
34                int move  = Math.min(num, h-1-y);
35                y+=move;
36                num-=move;
37                if(num > 0) dir = 2;
38            }else if(dir == 2){
39                int move = Math.min(num, x);
40                x -= move;
41                num -= move;
42                if(num > 0) dir = 3;
43            }else{
44                int move = Math.min(num, y);
45                y-= move;
46                num-= move;
47                if(num > 0) dir = 0;
48            }
49        }    
50    }
51    
52    public int[] getPos() {
53        return new int[]{x,y};
54    }
55    
56    public String getDir() {
57        if(dir == 0) return "East";
58        if(dir == 1) return "North";
59        if(dir == 2) return "West";
60        return "South";
61
62    }
63}
64
65/**
66 * Your Robot object will be instantiated and called as such:
67 * Robot obj = new Robot(width, height);
68 * obj.step(num);
69 * int[] param_2 = obj.getPos();
70 * String param_3 = obj.getDir();
71 */