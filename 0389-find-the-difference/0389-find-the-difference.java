class Solution {
    public char findTheDifference(String s, String t) {
         Map<Character,Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)-1);
            if(mp.get(c)<0){
                return c;
            }
        }
        return 'x';
    }
}