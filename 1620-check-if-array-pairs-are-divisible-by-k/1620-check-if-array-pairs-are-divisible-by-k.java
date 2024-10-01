class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++)
        {
            hm.put(((arr[i] % k) + k) % k, hm.getOrDefault(((arr[i] % k) + k) % k, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            int x = entry.getKey();
            if( x != (k - x) && x != 0) 
            {
                if(hm.containsKey(k - x))
                {
                    if(!((int)hm.get(x) == (int)hm.get(k - x)))
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else if (!( hm.getOrDefault(x,0) % 2 == 0))
            {
                return false;
            }
        }

        return true;
    }
}