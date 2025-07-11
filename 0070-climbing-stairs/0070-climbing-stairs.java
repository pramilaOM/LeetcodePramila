class Solution {

int[] t = new int[46];
    int solve(int step, int last) {

        if (step == last) {
            t[last] =1;
            return t[last];
        } else if (step > last) {
            return 0;
        }

        if(t[step] !=-1){
            return t[step];
        }

        t[step]= solve(step + 1, last) + solve(step + 2, last);
        return t[step];
    }

    public int climbStairs(int n) {
        Arrays.fill(t,-1);
        return solve(0, n);

    }
}