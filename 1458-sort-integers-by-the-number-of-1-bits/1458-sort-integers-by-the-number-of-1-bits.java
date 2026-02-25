class Solution {
    public int[] sortByBits(int[] arr) 
    {
        int n=arr.length;
        Integer[] nums=new Integer[n];

        for(int i=0;i<n;i++)
        {
            nums[i]=arr[i];
        }

        Arrays.sort(nums,(a,b)->{
            int countA=Integer.bitCount(a);
            int countB=Integer.bitCount(b);

            if(countA==countB) return a.compareTo(b);
            return Integer.compare(countA,countB);
        });

        for(int i=0;i<n;i++)
        {
            arr[i]=nums[i];
        }

        return arr;


    }
}