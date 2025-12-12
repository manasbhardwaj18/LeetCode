// Last updated: 12/12/2025, 1:31:32 PM
1class Solution {
2    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
3        int[] mentions = new int[numberOfUsers];
4        int[] offTime = new int[numberOfUsers];
5
6        Collections.sort(events, (a,b)-> Integer.parseInt(a.get(1))==Integer.parseInt(b.get(1))? b.get(0).compareTo(a.get(0)):Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1)));
7        
8        for(int i=0;i<events.size();i++){
9            if(events.get(i).get(0).equals("MESSAGE")){
10                messageFunc(events.get(i), mentions, offTime);
11            }else if(events.get(i).get(0).equals("OFFLINE")){
12                offlineFunc(events.get(i),mentions,offTime);
13            }
14        }
15        return mentions;
16    }
17    void messageFunc(List<String> event, int[] mentions, int[] offTime){
18        int time = Integer.parseInt(event.get(1));
19        String[] str = event.get(2).split(" ");
20        for(String s:str){
21            if(s.equals("ALL")){
22                for(int i=0;i<mentions.length;i++){
23                    mentions[i] += 1;
24                }
25            }else if(s.equals("HERE")){
26                for(int i=0;i<mentions.length;i++){
27                    if(offTime[i] == 0){
28                        mentions[i] += 1;
29                    }else if(offTime[i] + 60 <= time){
30                        mentions[i] += 1;
31                        offTime[i] = 0;
32                    }
33                }
34            }else{
35                int index = Integer.parseInt(s.substring("id".length()));
36                mentions[index] += 1; 
37            }
38        }
39    }
40
41    void offlineFunc(List<String> event, int[] mentions, int[] offTime){
42        int time = Integer.parseInt(event.get(1));
43        String[] str = event.get(2).split(" ");
44
45        for(String s : str){
46            int index = Integer.parseInt(s);
47            offTime[index] = time;
48        }
49    }
50}