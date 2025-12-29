// Last updated: 12/29/2025, 1:23:46 PM
1class Solution {
2    public boolean pyramidTransition(String bottom, List<String> allowed) {
3        Map<String, List<Character>> map = new HashMap<>();
4        for (String s : allowed) {
5            String key = s.substring(0, 2);
6            char top = s.charAt(2);
7            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
8        }
9        return dfs(bottom, map);
10    }
11
12    private boolean dfs(String current, Map<String, List<Character>> map) {
13        if (current.length() == 1) {
14            return true;
15        }
16        return buildNext(current, 0, new StringBuilder(), map);
17    }
18
19    private boolean buildNext(String current, int index, StringBuilder next,Map<String, List<Character>> map) {
20            if (index == current.length() - 1) {
21                return dfs(next.toString(), map);
22            }
23
24            String key = current.substring(index, index + 2);
25            if (!map.containsKey(key)) {
26                return false;
27            }
28
29            for (char c : map.get(key)) {
30                next.append(c);
31                if (buildNext(current, index + 1, next, map)) {
32                    return true;
33                }
34                next.deleteCharAt(next.length() - 1); 
35            }
36
37            return false;
38        }
39}