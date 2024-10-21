class Solution {
    public int maxUniqueSplit(String s) {

        return count(s, 0, s.length(), new HashSet<String>());
    }
    public int count(String s, int index, int n, Set<String> hs)
    {
        if(index == s.length())
        {
            return 0;
        }
        int max = 0;
        for(int i = index + 1; i <= s.length(); i++)
        {
            String w = s.substring(index , i);
            if(!hs.contains(w))
            {
                hs.add(w);
                max = Math.max(max, count(s, i, n, hs)+1);
                hs.remove(w);
            }
        }
        return max;
    }
}