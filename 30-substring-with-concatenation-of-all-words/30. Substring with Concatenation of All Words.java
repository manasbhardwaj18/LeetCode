class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
         ArrayList<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0)
        {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String w: words)
        {
            if(map.containsKey(w))
            {
                map.put(w, map.get(w)+1);
            }
            else
            {
                map.put(w, 1);
            }
        }
        int len = words[0].length();
        for(int j=0; j<len; j++)
        {
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;
            int count = 0;
            for(int i=j; i<=s.length()-len; i=i+len)
            {
                String sub = s.substring(i, i+len);
                if(map.containsKey(sub))
                {
                    if(currentMap.containsKey(sub))
                    {
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }
                    else
                    {
                        currentMap.put(sub, 1);
                    }
                    count++;
                    while(currentMap.get(sub)>map.get(sub))
                    {
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                    if(count==words.length)
                    {
                        result.add(start); 
                        
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }
                else
                {
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }
        return result;
    }
}