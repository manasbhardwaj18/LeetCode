// Last updated: 5/28/2026, 1:42:37 PM
1class Solution {
2    class Node{
3        int bestId;
4        Node[] child = new Node[26];
5        Node(){
6            bestId = 0;
7        }
8    }
9    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
10        Node root  = new Node();
11        for(int i=0; i < wordsContainer.length; i++){
12            String w = wordsContainer[i];
13            Node n1 = root;
14
15            if(wordsContainer[n1.bestId].length() > w.length()){
16                n1.bestId = i;
17            }
18
19            for(int j = w.length()-1; j>=0; j--){
20                int c = w.charAt(j) - 'a';
21                if(n1.child[c] == null){
22                    n1.child[c] = new Node();
23                    n1.child[c].bestId = i;
24                }else{
25                    if(wordsContainer[n1.child[c].bestId].length() > w.length()){
26                        n1.child[c].bestId = i;
27                    }
28                }
29                n1 = n1.child[c];
30            }
31        }
32        int[] ans = new int[wordsQuery.length];
33        for(int i=0; i < wordsQuery.length; i++){
34            String q = wordsQuery[i];
35            Node n1 = root;
36            for(int j = q.length()-1; j>=0; j--){
37                int c = q.charAt(j) - 'a';
38                if(n1.child[c] == null) break;
39                n1 = n1.child[c];
40            }
41            ans[i] = n1.bestId;
42        }
43        return ans;
44    }
45}