class Solution {
    public boolean isMatch(String s, String p) {
        StringBuffer s1 = new StringBuffer(s);
        StringBuffer p1 = new StringBuffer(p);
        for(int i = 0; i < s1.length(); i++){
            for (int j = 0; j < p1.length(); j++){
                if(j > 0 && p1.charAt(j) == '*' && p1.charAt(j-1) == '.'){
                   p1.replace(j,j+1,".");
                }
                if(s1.charAt(i) == p1.charAt(j)){
                    i++;
                    break;
                }else if( p1.charAt(j) == '.' ){
                    i++;
                    j++;
                }else if(p1.charAt(j) == '*' && j > 0 && p1.charAt(j-1) == s1.charAt(i)){
                    i++;
                }else if(p1.charAt(j) == '*' && j > 0 && p1.charAt(j-1) != s1.charAt(i)){
                    return false;
                }
            }
            if(i > p1.length()){
                return true;
            }
        }
        return false;
    }
}