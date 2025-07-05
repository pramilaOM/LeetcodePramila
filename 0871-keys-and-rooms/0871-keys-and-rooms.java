class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited)
                return false;
        }
        return true;
    }

    void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        visited[currentRoom] = true;
        for (int key : rooms.get(currentRoom)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}