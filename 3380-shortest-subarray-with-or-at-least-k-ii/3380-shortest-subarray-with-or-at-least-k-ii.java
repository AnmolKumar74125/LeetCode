class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, n = nums.length;
        int val = 0;
        int arr[] = new int[32];
        while(i < n)
        {
            val = 0;
            int p = nums[i];
            for(int x = 0; x < 32; x++)
            {
                if(p > 0)
                {
                    if((p & 1) == 1)
                    {
                        arr[x]++;
                    }
                    p = p >> 1;
                }
                else
                {
                    break;
                }
            }
            for(int x = 31; x >= 0; x--)
            {
                val = (val << 1) | ((arr[x] > 0) ? 1 : 0);
            }
            while(j <= i && val >= k)
            {
                min = Math.min(min, i-(j-1));
                p = nums[j];
                val = 0;
                for(int x = 0; x < 32; x++)
                {
                    if(p > 0)
                    {
                        if((p & 1) == 1)
                        {
                            arr[x]--;
                        }
                        p = p >> 1;
                    }
                    else
                    {
                        break;
                    }
                }
                for(int x = 31; x >= 0; x--)
                {
                    val = (val << 1) | ((arr[x] > 0) ? 1 : 0);
                }
                j++;
            }
            i++;
        }
        if(min == Integer.MAX_VALUE)
        {
            return -1;
        }
        return min;
    }
}