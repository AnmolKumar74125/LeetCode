class Solution {
    public boolean rotateString(String s, String goal) {
        
        for(int i = 0; i < s.length(); i++)
        {
            String w = s.substring(i+1) + s.substring(0,i+1);
            if(w.equals(goal))
            {
                return true;
            }
        }
        return false;
    }
}