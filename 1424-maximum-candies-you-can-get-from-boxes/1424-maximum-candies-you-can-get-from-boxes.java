import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] used = new boolean[n]; 
        boolean[] boxAvailable = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            boxAvailable[box] = true;
        }

        int totalCandies = 0;

        boolean progress = true;
        while (progress) {
            progress = false;
            for (int i = 0; i < n; i++) {
                if (!used[i] && boxAvailable[i] && (status[i] == 1 || hasKey[i])) {
                    totalCandies += candies[i];
                    used[i] = true;
                    progress = true;
                    for (int key : keys[i]) {
                        hasKey[key] = true;
                    }
                    for (int box : containedBoxes[i]) {
                        boxAvailable[box] = true;
                    }
                }
            }
        }

        return totalCandies;
    }
}
