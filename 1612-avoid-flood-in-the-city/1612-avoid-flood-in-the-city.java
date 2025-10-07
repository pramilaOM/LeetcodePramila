class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1); // Initialize with -1 for rainy days or no action

        // Stores the last day a lake became full: (lakeId, dayIndex)
        HashMap<Integer, Integer> lakeIdToFullDay = new HashMap<>();
        // Stores indices of sunny days (rains[i] == 0) available for drying
        TreeSet<Integer> emptyDays = new TreeSet<>();

        for (int i = 0; i < rains.length; ++i) {
            final int lakeId = rains[i];

            if (lakeId == 0) { // It's a sunny day
                emptyDays.add(i);
            } else { // It's a rainy day
                if (lakeIdToFullDay.containsKey(lakeId)) {
                    // This lake was full before. We need to dry it before this rain.
                    final int lastFullDay = lakeIdToFullDay.get(lakeId);

                    // Find the earliest sunny day AFTER the last full day to dry this lake
                    Integer dryDay = emptyDays.higher(lastFullDay);

                    if (dryDay == null) {
                        // No available sunny day to prevent flood
                        return new int[]{};
                    }

                    // Dry the lake on this sunny day
                    ans[dryDay] = lakeId;
                    emptyDays.remove(dryDay);
                }
                // The lake with `lakeId` becomes full on day `i`
                lakeIdToFullDay.put(lakeId, i);
                // No action on this day for ans, as the lake becomes full
                ans[i] = -1; 
            }
        }

        // Fill remaining unused sunny days with an arbitrary lake to dry (e.g., lake 1)
        for (final int emptyDay : emptyDays) {
            ans[emptyDay] = 1;
        }

        return ans;
    }
}