class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int  i = 0, j = 0, max = 0;
        Set<Character> hs = new HashSet<Character>();
        int curr = 0;
        while(i <= j && j < s.length() &&(s.length()-i > max))
        {
            char ch = s.charAt(j);
            if(!hs.contains(ch))
            {
                hs.add(ch);
                max = Math.max(max,j - i + 1);
                j++;
            }
            else
            {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}