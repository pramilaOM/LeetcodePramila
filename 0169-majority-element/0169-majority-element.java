class Solution {
    public int majorityElement(int[] nums) {
        //bf
        // TC O(n) for building frequency map + O(n) for final scan → O(n) total
        // SC O(n) for storing counts in a hash map or frequency structure

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

       for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }

       } 

       return -1; 

    }
}