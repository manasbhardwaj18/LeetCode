// Last updated: 12/19/2025, 1:52:18 PM
1class Solution {
2    int[] one, two;
3    int find(int x){
4        if(one[x] !=  x){
5            one[x] = find(one[x]);
6        }
7        return one[x];
8    }
9    void union(int a, int b){
10        int onea = find(a), oneb = find(b);
11        if(onea == oneb){
12            return;
13        }
14        if(two[onea] < two[oneb]){
15            one[onea] = oneb;
16        }else if(two[onea] > two[oneb]){
17            one[oneb] = onea;
18        }else{
19            one[oneb] = onea;
20            two[onea]++;
21        }
22    }
23
24    void reset(int x){
25        one[x] = x;
26        two[x] = 0;
27    }
28
29    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
30        Arrays.sort(meetings, (a,b) -> a[2]-b[2]);
31        one = new int[n];
32        two = new int[n];
33        for(int i=0;i<n;i++){
34            one[i] = i;
35        }
36        union(0, firstPerson);
37        int i=0, m = meetings.length;
38        while(i<m){
39            int time = meetings[i][2];
40            List<Integer> list = new ArrayList<>();
41            while(i<m && meetings[i][2] == time){
42                union(meetings[i][0], meetings[i][1]);
43                list.add(meetings[i][0]);
44                list.add(meetings[i][1]);
45                i++;
46            }
47
48            for(int p:list){
49                if(find(0) != find(p)){
50                    reset(p);
51                }
52            }
53        }
54
55        List<Integer> val = new ArrayList<>();
56        for(int z = 0; z<n;z++){
57            if(find(0) == find(z)){
58                val.add(z);
59            }
60        }
61        return val;
62    }
63}