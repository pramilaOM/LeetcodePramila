class Solution {
    public boolean isValid(String s) {
        //brute force approach
        //Repeatedly remove valid bracket pairs like "()", "[]", and "{}" from the string.
        //If, after all possible removals, the string becomes empty → it is valid.
        //If any characters remain → it is invalid.
        
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            s= s.replace("()","");
            s= s.replace("[]","");
            s= s.replace("{}","");
        }
        return s.isEmpty();
        
    }
}