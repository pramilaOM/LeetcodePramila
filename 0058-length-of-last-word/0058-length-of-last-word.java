class Solution {
    public int lengthOfLastWord(String s) {
        s= s.trim();
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = sb.length()-1; i>=0;i--){
            if(sb.charAt(i) == ' '){
                break;
            }
            count++;
        }
        return count;
        
    }
}