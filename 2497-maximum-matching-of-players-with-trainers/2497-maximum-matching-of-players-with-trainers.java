class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i = 0, j = 0, count = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
                count++;
            }
            j++;

        }
        return count;
    }
}