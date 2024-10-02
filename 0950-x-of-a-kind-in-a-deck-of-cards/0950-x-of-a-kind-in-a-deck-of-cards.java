class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();

        if( deck.length == 1)
        {
            return false;
        }
        for(int i=0;i<deck.length;i++)
        {
            if(hm.containsKey(deck[i]))
            {
                hm.put(deck[i],hm.get(deck[i])+1);
            }
            else
            {
                hm.put(deck[i],1);
            }
        }
        System.out.println(hm);
        Integer arr[] = hm.values().toArray(new Integer[0]);
        int gcd = (int)arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            gcd = findGCD( gcd , (int)arr[i]);
            if(gcd < 2)
            {
                return false;
            }
        }
        return true;
    }
    public int findGCD(int a , int b)
    {
        if( a == 0)
        {
            return b;
        }
        return findGCD( b % a , a);
    }
}