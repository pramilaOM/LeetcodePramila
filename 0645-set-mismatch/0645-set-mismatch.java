class Solution {
    public int[] findErrorNums(int[] nums) {

        Map<Integer,Integer> data = new HashMap<>();
        for(int n :nums){
            data.put(n,data.getOrDefault(n, 0)+1);
        }
        int duplicate = -1, missing = -1;
        for(int i =1;i<=nums.length;i++){
            int count = data.getOrDefault(i, 0);
             if(count== 2){
                duplicate = i;
             } else if(count ==0){
                missing = i;
             }
        }
       
        return new int[]{duplicate,missing};
        
    }
}