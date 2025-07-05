class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalKarcha = 0,totalKamayi=0;
        for(int n : gas){
            totalKarcha+= n;
        }
        for(int n : cost){
            totalKamayi+= n;
        }

        if(totalKarcha < totalKamayi ){
            return -1;
        }
        
        int total = 0;
        int result = 0;
        for(int i = 0;i<gas.length;i++){
            total = total+ gas[i]-cost[i];
            if(total < 0){
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}