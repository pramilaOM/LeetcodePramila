class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> lost = new HashMap<>();

        for (int[] i : matches) {
            int data = i[1];
            lost.put(data, lost.getOrDefault(data, 0) + 1);
        }

        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        for (int[] i : matches) {
            int lose = i[1];
            int win = i[0];

            if (lost.get(lose) == 1) {
                oneLose.add(lose);
            }
            if (!lost.containsKey(win)) {
                noLose.add(win);
                lost.put(win, 2);
            }

        }

        Collections.sort(noLose);
        Collections.sort(oneLose);

        return Arrays.asList(noLose, oneLose);

    }
}