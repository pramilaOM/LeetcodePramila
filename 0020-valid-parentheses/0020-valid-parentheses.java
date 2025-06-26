class Solution {
    public boolean isValid(String s) {
        //brute force approach
        //Repeatedly remove valid bracket pairs like "()", "[]", and "{}" from the string.
        //If, after all possible removals, the string becomes empty → it is valid.
        //If any characters remain → it is invalid.

        //contains Checks if the string s contains the substring "()".
        //replace Replaces all occurrences of "()" with "" (empty string), effectively removing them.
        //isEmpty Checks if the string s has length 0 (i.e., it's empty).
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            s= s.replace("()","");
            s= s.replace("[]","");
            s= s.replace("{}","");
        }
        return s.isEmpty();
        
    }
}