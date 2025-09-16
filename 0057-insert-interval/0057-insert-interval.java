class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //bf
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0])
                i++;
            else if (intervals[i][0] > newInterval[1]) {
                List<int[]> result = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    result.add(intervals[j]);
                }
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                List<int[]> tempList = new ArrayList<>();
                for (int j = 0; j < intervals.length; j++) {
                    if (j != i) {
                        tempList.add(intervals[j]);
                    }
                }
                intervals = tempList.toArray(new int[tempList.size()][]);
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            result.add(interval);
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}