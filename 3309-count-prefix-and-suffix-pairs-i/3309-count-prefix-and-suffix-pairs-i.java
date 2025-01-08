class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int ans = 0;
        for(int i = 0; i < words.length - 1; i++)
        {
            for(int j = i+1; j < words.length; j++)
            {
                if(isPrefixAndSuffix(words[i],words[j]))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPrefixAndSuffix(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2)
        {
            return false;
        }
        if(s1.equals(s2))
        {
            return true;
        }
        if(s1.equals(s2.substring(0,len1)) && s1.equals(s2.substring(len2-len1)))
        {
            return true;
        }
        return false;
    }
}