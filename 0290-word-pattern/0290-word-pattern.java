class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<Character, String> hm = new HashMap<Character, String>();
        Map<String, Character> hm2 = new HashMap<String, Character>();
        s = s+" ";
        int i = 0, k = 0, n1 = pattern.length(), n2 = s.length();
        while(k < n2 && i < n1)
        {
            char ch = pattern.charAt(i);
            int x = s.indexOf(' ',k);
            String w = s.substring(k,x);
            k = x + 1;
            i++;
            if(hm.containsKey(ch) || hm2.containsKey(w))
            {
                if(!w.equals(hm.getOrDefault(ch,"")) || ch != hm2.getOrDefault(w,' '))
                {
                    return false;
                }
                continue;
            }
            hm.put(ch, w);
            hm2.put(w, ch);
        }
        if(k < n2 || i < n1)
        {
            return false;
        }
        return true;
    }
}