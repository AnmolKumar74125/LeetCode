class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder str = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);
        str.append(prev);
        for(int i = 1; i < s.length(); i++)
        {
            if(prev == s.charAt(i))
            {
                count ++;
            }
            else
            {
                prev = s.charAt(i);
                count = 1;
            }
            if(count < 3)
            {
                str.append(prev);
            }
        }
        return str.toString();
    }
}