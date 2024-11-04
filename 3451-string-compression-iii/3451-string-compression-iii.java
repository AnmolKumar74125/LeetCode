class Solution {
    public String compressedString(String word) {
        
        StringBuilder ans = new StringBuilder();
        //String ans = "";
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
                    ans.append(count + "" + prev);
                    //ans = ans + count + prev;
                    count = 0;
                    prev = ch;
                }
                count++;
            }
            else
            {
                ans.append(count + "" + prev);
                //ans = ans + count + prev; 
                count = 1;
                prev = ch;
            }
            i++;
        }

        if(prev == word.charAt(n-1))
        {
            ans.append(count + "" + prev);
        }
        else
        {
            ans.append("1"+word.charAt(n-1));
        }
        //return ans;
        return ans.toString();
    }
}