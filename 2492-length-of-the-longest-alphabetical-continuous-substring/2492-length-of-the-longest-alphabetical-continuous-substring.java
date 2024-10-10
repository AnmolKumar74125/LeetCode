class Solution {
    public int longestContinuousSubstring(String s) {
        
        int n = s.length();
        int max = 1 , count = 1;
        char prev = s.charAt(0);
        for(int i = 1; i < n; i++)
        {
            char curr = s.charAt(i);
            if(curr - 1 !=prev)
            {
                count = 1;
            }
            else
            {
                max = (max < ++count) ? count : max; 
            }
            prev = curr;
        }
        return max;
    }
}