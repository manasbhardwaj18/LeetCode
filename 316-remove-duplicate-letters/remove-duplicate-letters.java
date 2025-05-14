class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int [] lastPos = new int [26]; 
        boolean [] added = new boolean [26]; 
        for (int i = 0; i < s.length(); i++)
        {
            lastPos[s.charAt(i) - 'a'] = i; 
        }
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (added[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && lastPos[stack.peek() - 'a'] > i)
            {
                added[stack.peek() - 'a'] = false;
                stack.pop();
            }
            added[c-'a'] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
        {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}