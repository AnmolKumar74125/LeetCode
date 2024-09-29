class Solution {
    public int countOfSubstrings(String word, int k) {

        Map<Character, Integer> hm =new HashMap<Character, Integer>();        
        int count = 0,cons = 0;
        int i = 0, j = 0;
        int nextCons = getNextCons(0,word);
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
                    if( nextCons <= i)
                    {
                        nextCons = getNextCons(i+1, word);
                    }
                    count = count + (nextCons - i) ;
                }
                ch = word.charAt(j);
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
    public int getNextCons(int i, String word)
    {
        for( ;i< word.length();i++)
        {
            char ch = word.charAt(i);
            if(!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'))
            {
                return i;
            }
        }
        return word.length();
    }
}