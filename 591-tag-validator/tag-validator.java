class Solution {
      public boolean isValid(String exp) {
        int length = exp.length();
        Stack S=new Stack();
        for (int i = 0; i < length; i++) {
            if(i>0 && S.empty())
                return false;
            if(exp.startsWith("<![CDATA[",i)){
                int pos=exp.indexOf("]]>",i+9);
                if (pos==-1)
                    return false;
                else
                    i=pos+2;
            }
            else if(exp.startsWith("</",i)){
                int pos=exp.indexOf('>',i+2);
                if (pos==-1) {
                    return false;
                }
                String to_be_matched=exp.substring(i+2,pos);
                if(S.empty())
                   return false;
                if(!to_be_matched.equals((String)S.pop()))
                    return false;
                i=pos;
            }
            else if (exp.charAt(i) == '<') {
                int pos=exp.indexOf('>',i+1);
                if (pos==-1)
                    return false;
                String to_be_pushed=exp.substring(i+1, pos);
                if(!(to_be_pushed.length() >=1 && to_be_pushed.length() <=9))
                    return false;
                for(int k=0;k<to_be_pushed.length();k++) {
                    char temp = to_be_pushed.charAt(k);
                    if (!(temp >= 65 && temp <= 90))
                        return false;
                }
                S.push(to_be_pushed);
                i=pos;
            }
            else
            {
                int pos=exp.indexOf('<',i);
                if (pos!=-1) {
                    i=pos-1;
                }
            }
        }
        if(S.empty())
            return true;
        else
            return false;
    }
}