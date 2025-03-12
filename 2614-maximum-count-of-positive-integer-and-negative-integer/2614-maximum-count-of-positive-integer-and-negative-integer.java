class Solution {
    public int maximumCount(int[] nums) {
        
        int c = 0, n = nums.length, z = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < 0)
            {
                c++;
            }
            else if(nums[i] == 0)
            {
                z++;
            }
            else
            {
                break;
            }
        }
        return Math.max(c, (n - z) - c);
    }
}