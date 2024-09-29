class Solution {
    public int countOfSubstrings(String word, int k) {
        
        Map<Character, Integer> hm =new HashMap<Character, Integer>();        
        int count = 0,cons = 0;
        int i = 0, j = 0;
        while(i < word.length())
        {
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            }
            else
            {
                cons ++;
            }
            while(hm.size() == 5 && cons >= k)
            {
                if(cons == k)
                {
                    count ++;
                }
                int x = i;
                while( x < word.length()-1 && cons == k)
                {
                    ch = word.charAt(x+1);
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                    x++;
                }
                ch = word.charAt(j);
                  System.out.println(hm);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    hm.put(ch, hm.get(ch)-1);
                    if(hm.get(ch) == 0)
                    {
                        hm.remove(ch);
                    }
                }
                else
                {
                    cons--;
                }
                
                j++;
            }
            i++;
        }
        return count;
    }
}