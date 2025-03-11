class Solution {
    public int numberOfSubstrings(String s) {

        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        int i = 0, j = 0, n = s.length();
        int ans = 0;
        while(i <= j && j < n)
        {
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            while(i <= j && hm.size() == 3)
            {
                ans = ans + (n - j);
                ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) - 1);
                if(hm.get(ch) <= 0)
                {
                    hm.remove(ch);
                }
                i++;
            }
            j++;
        }   
        return ans;
    }
}