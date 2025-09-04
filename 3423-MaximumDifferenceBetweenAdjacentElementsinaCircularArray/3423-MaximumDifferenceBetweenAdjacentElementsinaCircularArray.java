// Last updated: 9/5/2025, 1:02:41 AM
class Solution {
    public int matchPlayersAndTrainers(int[] player, int[] trainers) {
        Arrays.sort(player);
        Arrays.sort(trainers);
        int i = 0, j = 0, count = 0;
        while (i < player.length && j < trainers.length) {
            if (player[i] <= trainers[j]) {
                i++; count++;
            }
            j++;
        }
        return count;
    }
}
