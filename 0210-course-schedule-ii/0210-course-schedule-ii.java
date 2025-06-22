class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       

       List<List<Integer>> graph = new ArrayList<>();
       int[] inDegree = new int[numCourses];

       for(int i = 0;i<numCourses;i++){
        graph.add(new ArrayList<>());
       }

       for(int[] pair : prerequisites){
        int course = pair[0];
        int prereq = pair[1];
        graph.get(prereq).add(course);
        inDegree[course]++;
       }

       Queue<Integer> queue = new LinkedList<>();
       for(int i = 0;i< numCourses;i++){
        if(inDegree[i]==0){
            queue.offer(i);
        }
       }
       List<Integer> result = new ArrayList<>();
       while(!queue.isEmpty()){
        int current = queue.poll();
        result.add(current);

        for(int neighbor : graph.get(current)){
            inDegree[neighbor]--;
            if(inDegree[neighbor] ==0){
                queue.offer(neighbor);
            }
        }
       }
        if(result.size() == numCourses){
            int[] order = new int[numCourses];
            for(int i = 0;i<numCourses;i++){
                order[i] = result.get(i);
            }
            return order;
        }
        return new int[0];       
    }
}