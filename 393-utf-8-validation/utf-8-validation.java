class Solution {
	public boolean validUtf8(int[] data) {
		int remaining=0;
		for(int i:data){
			if(remaining==0){
				if(i>>7==0b0){
					remaining = 0;
				}
				else if(i>>5==0b110){
					remaining = 1;
				}
				else if(i>>4==0b1110){
					remaining = 2;
				}
				else if(i>>3==0b11110){
					remaining = 3;
				}
				else{
					return false;
				}
			}
			else{
				if(i>>6==0b10){
					remaining--;
				}
				else{
					return false;
				}
			}
		}
		return remaining==0?true:false;

	}
}