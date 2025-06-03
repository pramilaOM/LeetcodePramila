class Solution {

    public int dfs(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
                   Set<Integer> visited, Set<Integer> foundBoxes) {

        if (visited.contains(box)) {
            return 0;
        }

        if (status[box] == 0) {
            foundBoxes.add(box);
            return 0;
        }

        visited.add(box);
        int candiesCollected = candies[box];

        // First process keys
        for (int boxKey : keys[box]) {
            status[boxKey] = 1;
            if (foundBoxes.contains(boxKey)) {
                candiesCollected += dfs(boxKey, status, candies, keys, containedBoxes, visited, foundBoxes);
            }
        }

        // Then process contained boxes
        for (int innerBox : containedBoxes[box]) {
            candiesCollected += dfs(innerBox, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        return candiesCollected;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int candiesCollected = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> foundBoxes = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            queue.add(box);
        }

        while (!queue.isEmpty()) {
            int box = queue.poll();
            int before = visited.size();
            candiesCollected += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes);
            // Revisit boxes in foundBoxes in case new keys unlocked them
            if (visited.size() > before) {
                for (int b : new HashSet<>(foundBoxes)) {
                    queue.offer(b);
                }
            }
        }

        return candiesCollected;
    }
}
