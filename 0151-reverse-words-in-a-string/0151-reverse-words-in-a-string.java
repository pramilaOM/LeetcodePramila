class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("\\s+");
        int n = str.length;
        for(int i = n-1;i>=0;i--){
            sb = sb.append(str[i]+" ");
        }
        return sb.toString().trim();
    }
}