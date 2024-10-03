class Solution {
    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        int val = 0;
        for(int i = 0; i < n; i++)
        {
            nums[i] = nums[i] % p;
            val = (val + nums[i]) % p;
        }
        if(val == 0)
        {
            return 0;
        }
        Map<Integer,Integer> hm =new HashMap<Integer,Integer>();
        int curr = 0, ans = Integer.MAX_VALUE;
        hm.put(0 , -1);
        System.out.println("val = "+val);
        System.out.println(hm);
        for(int i = 0; i < n; i++)
        {
            curr = (curr + nums[i]) % p;
            int key = ((curr - val) + p) % p;
            //System.out.println(key);
            if(hm.containsKey(key))
            {
                ans = Math.min(ans, (i - hm.get(key)));
            }
            hm.put(curr, i);
            //System.out.println(hm);
        }   
        System.out.println(hm);
        if(ans == Integer.MAX_VALUE || ans == n)
        {
            ans = -1;
        }
        return (int)ans;
    }
}