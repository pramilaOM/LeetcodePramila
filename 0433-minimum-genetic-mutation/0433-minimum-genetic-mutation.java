class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        visited.add(startGene);

        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String curr = queue.poll();
                if(curr.equals(endGene)){
                    return level;
                }

                for(char ch : new char[]{'A','C','G','T'}){
                    for(int i = 0; i< curr.length();i++){
                        char[] arr = curr.toCharArray();
                        arr[i] = ch;
                        String neighbor = new String(arr);
                        if(!visited.contains(neighbor) && bankSet.contains(neighbor)){
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}