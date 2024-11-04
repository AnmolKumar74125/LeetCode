class Solution {
    public String compressedString(String word) {
        
        StringBuilder ans = new StringBuilder();
        int i = 1, count = 1;
        int n = word.length();
        char prev = word.charAt(0);
        if( n == 1)
        {
            return "1" + word;
        }
        while(i < n)
        {
            char ch = word.charAt(i);
            if(prev == ch)
            {
                if(count == 9)
                {
                    ans.append(count).append(prev);
                    count = 0;
                    prev = ch;
                }
                count++;
            }
            else
            {
                ans.append(count).append(prev);
                count = 1;
                prev = ch;
            }
            i++;
        }
        ans.append(count).append(prev);
        return ans.toString();
    }
}