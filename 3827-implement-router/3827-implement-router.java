class Router {

    private int MAX_SIZE;
    private Map<String, int[]> packetStore;
    private Map<Integer, ArrayList<Integer>> destTimestamps;
    private Map<Integer, Integer> startIndex;
    private Queue<String> que;

    public Router(int memoryLimit) {
        MAX_SIZE = memoryLimit;
        packetStore = new HashMap<>();
        destTimestamps = new HashMap<>();
        startIndex = new HashMap<>();
        que = new LinkedList<>();
    }

    private String makeKey(int source, int destination, int timestamp) {
        return source + "#" + destination + "#" + timestamp;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = makeKey(source, destination, timestamp);
        if (packetStore.containsKey(key))
            return false;

        if (packetStore.size() >= MAX_SIZE) {
            forwardPacket();
        }
        packetStore.put(key, new int[] { source, destination, timestamp });
        que.offer(key);

        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destTimestamps.get(destination).add(timestamp);
        startIndex.putIfAbsent(destination, 0);
        return true;
    }

    public int[] forwardPacket() {
        if (packetStore.isEmpty())
            return new int[0];

        String key = que.poll();
        int[] packet = packetStore.get(key);
        packetStore.remove(key);

        int dest = packet[1];
        int idx = startIndex.get(dest);
        startIndex.put(dest, idx + 1);
        return packet;

    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination))
            return 0;
        ArrayList<Integer> list = destTimestamps.get(destination);
        int idx = startIndex.get(destination);
        int left = lowerBound(list, startTime, idx);
        int right = upperBound(list, endTime, idx);

        return right - left;

    }

    private int lowerBound(ArrayList<Integer> list, int target, int startIdx) {
        int low = startIdx, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private int upperBound(ArrayList<Integer> list, int target, int startIdx) {
        int low = startIdx, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */