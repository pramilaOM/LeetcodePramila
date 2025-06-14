class Solution {
    public int minMaxDifference(int num) {

        String s = String.valueOf(num);
        char startMax = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != '9'){
                startMax = s.charAt(i);
                break;
            }
        }
        
        String maxString =(startMax != 0)? s.replace(startMax,'9'):s;
        int max = Integer.valueOf(maxString);

        char end = s.charAt(0);
        String minString = s.replace(end,'0');
        int min = Integer.valueOf(minString);

        return max-min;
    }
}