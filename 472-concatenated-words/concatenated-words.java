   class Solution {	 
   public List<String> findAllConcatenatedWordsInADict(String[] words) {
   
    Arrays.sort(words, (a,b) -> a.length() - b.length());
    
	List<String> result = new ArrayList<>();
    
    HashSet<String> preWords = new HashSet<>();
    
    for(int i=0; i< words.length; i++){
        if(wordBreak(words[i], preWords)) result.add(words[i]);
        preWords.add(words[i]);
    }
    return result;
   }
   
   private boolean wordBreak(String s, HashSet<String> preWords){
    if(preWords.isEmpty()) return false;
    
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    
    for(int i = 1; i <= s.length(); i++){
        for(int j = 0; j < i; j++){
            if(dp[j] && preWords.contains(s.substring(j, i))){
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
   }
   }
   
   