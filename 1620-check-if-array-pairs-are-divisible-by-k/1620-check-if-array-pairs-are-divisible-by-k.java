class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++)
        {
            hm.put(((arr[i] % k) + k) % k, hm.getOrDefault(((arr[i] % k) + k) % k, 0) + 1);
        }
        System.out.println(hm);
 /*
        for(int i = 0; i < arr.length; i++)
        {
            int x = k - (arr[i] % k);
            x = x % k;
            if(!hm.containsKey(x))
            {
                System.out.println("A "+ x);
                return false;
            }
            hm.put(x , hm.get(x) - 1);
            if(hm.get(x) == 0)
            {
                hm.remove(x);
            }
            System.out.println(hm);
        }
        if(hm.size() == 0)
        {
            return true;
        }
*/

        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            int x = entry.getKey();
            //System.out.println(x + "    " + (k - (x % k)));
            if(x < 0)
            {
          //      if(!hm.containsKey(Math.abs(x)) || hm.get(x) != hm.get(Math.abs(x)))
            }
            if( x != (k - (x % k)) && x != 0) 
            {
                if(hm.containsKey(k - (x % k)))
                {
                   // System.out.println(x + "  = "+hm.get(x)+"    " + (k - (x % k))+ "  =  "+ hm.get(k - (x % k)));
                    if(!((((int)hm.get(x) == (int)hm.get(k - (x % k))))))
                    {
                        System.out.println("A");
                        return false;
                    }
                }
                else
                {
                    System.out.println("B");
                    return false;
                }
            }
            else if (!( hm.getOrDefault(x,0) % 2 == 0))
            {
                System.out.println("C");
                return false;
            }
        }

        return true;
    }
}