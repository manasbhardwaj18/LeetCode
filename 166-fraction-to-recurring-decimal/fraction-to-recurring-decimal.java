class Solution {
    public String fractionToDecimal(int n, int d) 
    {
        long a = Math.abs((long)n);
        long b = Math.abs((long)d);
        StringBuilder sb = new StringBuilder();
        if( (n<0 & d>0) || (n>0 && d<0))
            sb.append('-');
        sb.append(a/b);
        a = a%b;
        if(a > 0)
            sb.append('.');
    HashMap<Long,Integer> map = new HashMap<>();
        while(!map.containsKey(a))
        {
            map.put(a , map.size());
            a = a*10;
            if(a > 0)
                sb.append(a/b);
            a = a%b;
        }
        if(a > 0)
        {
            sb.insert(sb.length()-(map.size()-map.get(a)) , '(');
            sb.append(')');
        }
        return sb.toString();
    }
}