class Solution {
    public long countOfSubstrings(String word, int k) {

        Map<Character, Integer> hm =new HashMap<Character, Integer>();        
        long count = 0,cons = 0;
        int i = 0, j = 0;
        int n = word.length();
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
             // System.out.print("i = "+i+" j = "+j+"cons = "+cons+"  A = ");
             // System.out.println(hm);
            while(hm.size() == 5 && cons >= k)
            {
                if(cons == k)
                {
                    //count ++;
                    if( nextCons <= i && nextCons != -1)
                    {
                            nextCons = getNextCons(i+1, word);
                    }
                    if( nextCons == -1)
                    {
                        count = count + (n-i);
                    }
                    else
                    {
                        count = count + (nextCons - i) ;
                    }
                }
               /* int x = i;
                while( x < word.length()-1 && cons == k)
                {
                    ch = word.charAt(x+1);
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    {
                    //    break;
                        count++;
                    }
                    else
                    {
                        break;
                    }
                    x++;
                }
                */
                ch = word.charAt(j);
                  //System.out.println(hm);
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
 //           if(hm.size() == 5 && cons == k)
 //               count ++;
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
        return -1;
    }
}