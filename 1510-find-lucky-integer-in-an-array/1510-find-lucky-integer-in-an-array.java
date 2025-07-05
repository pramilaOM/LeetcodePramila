class Solution {
    public int findLucky(int[] arr) {
         Map<Integer,Integer> map = new HashMap<>();
        for(int n : arr){
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        int result = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int freq = entry.getValue();
            if(number == freq){
                result = Math.max(result,number);
            }
        }
        return result;
        
    }
}