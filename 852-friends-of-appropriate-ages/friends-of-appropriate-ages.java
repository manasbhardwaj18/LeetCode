class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0, i = 0, result = 0, prev = 0;
        for(i = 1; i < ages.length; i++) {
            while(left < i && ages[left] <= 0.5*ages[i]+7) left++;
            while(prev < i && ages[i] != ages[prev]) prev++;
            if(ages[i] == ages[prev] && ages[i] > 0.5*ages[i]+7) result+=i-prev;
            result+=i-left;
        }
        return result;
    }
}