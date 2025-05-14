class Solution {
    public int hIndex(int[] citations) {
        int lo=0;
        int hi=citations.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(citations[mid]==citations.length-mid){
                return citations[mid];
            }
            else if(citations[mid]<citations.length-mid){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return citations.length-lo;
    }
}