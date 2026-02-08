class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        char[] c = sentence.toCharArray();
        for(char ch : c){
            count[ch - 'a']++;
        }

        for(int n : count){
            if(n ==0){
                return false;
            }
        }
        return true;

    }
}