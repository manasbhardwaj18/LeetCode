// Last updated: 10/27/2025, 7:21:21 PM
class Solution {
    public int numberOfBeams(String[] bank) {
        int pre = 0;
        int ans = 0;
        int number_of_ones;
        for(int i = 0; i < bank.length; i++)
        {
            number_of_ones = 0;
            
            for(int j = 0; j < bank[i].length(); j++)
            {
                if(bank[i].charAt(j) == '1')
                {
                    number_of_ones ++;
                }
            }

            if(number_of_ones == 0)
            {
                continue;
            }

            ans = ans + (pre * number_of_ones);
            pre = number_of_ones;
        }

        return ans;
        
    }
}