class Solution {
    public int[][] merge(int[][] intervals) {
        //https://www.youtube.com/watch?v=9rCmrMed8h8
        //https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
        //always sort interval based problem
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];

            if (curr_start > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], curr_end);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}