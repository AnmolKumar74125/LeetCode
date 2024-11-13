class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        Arrays.sort(nums);
        int a = 0, b = nums.length - 1;
        long ans = 0;
        for(int i = 0; i < nums.length -1; i++)
        {
            int p1 = 0, p2 = 0;
            a = i+1;
            b = nums.length - 1;
            if(nums[i] + nums[b] < lower || nums[i]+nums[a] > upper)
            {
                continue;
            }
            while(a < nums.length && nums[i] + nums[a] < lower)
            {
                a++;
            } 
            while(b >= a && nums[i] + nums[b] > upper)
            {
                b--;
            }
            ans = ans + Math.max((b - a) + 1 , 0);
        }
        return ans;
    }
}