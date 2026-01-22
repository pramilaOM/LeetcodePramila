class Solution {
 private boolean isSorted(int[]nums,int n){
    for(int i=1;i<n;i++)
        if(nums[i]<nums[i-1]){
            return false;
        }
     return true;
 }
    public int minimumPairRemoval(int[] nums) {
   int ans=0,n=nums.length;
        while(!isSorted(nums,n)){
            ans++;
    int min=Integer.MAX_VALUE,pos=-1;
     for(int i=1;i<n;i++){
        int sum=nums[i]+nums[i-1];
         if(sum<min){
             min=sum;
             pos=i;
         }
     }
        nums[pos-1]=min;
    for(int i=pos;i<n-1;i++)
        nums[i]=nums[i+1];
            n--;
        }
        return ans;
    }
}