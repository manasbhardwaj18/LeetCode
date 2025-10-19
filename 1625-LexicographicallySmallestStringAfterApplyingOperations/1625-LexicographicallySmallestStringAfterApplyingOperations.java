// Last updated: 10/19/2025, 2:02:47 PM
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue= new LinkedList<>();
        Set<String> seen= new HashSet<>();
        String smallest= s;
        queue.add(s);
        seen.add(s);

        while(!queue.isEmpty()){
            String curr= queue.poll();
            if(curr.compareTo(smallest)<0){
                smallest= curr;
            }
            char[] arr= curr.toCharArray();
            for(int i=1; i<arr.length; i+=2){
                int val= (arr[i]-'0'+a)%10;
                arr[i]= (char)(val+'0');
            }
            String toAdd= new String(arr);
            if(seen.add(toAdd)){
                queue.add(toAdd);
            }
            String rotated= curr.substring(curr.length()-b, curr.length())+curr.substring(0, curr.length()-b);
            if(seen.add(rotated)){
                queue.add(rotated);
            }
        }
        return smallest;
    }
}