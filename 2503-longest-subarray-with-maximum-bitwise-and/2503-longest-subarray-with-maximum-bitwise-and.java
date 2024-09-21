class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int count = 0, maxCount = 0;
        for(int i = 0; i < n; i++)
        {
            max = Math.max(nums[i],max);
        } 
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == max)
            {
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else
            {
                count = 0;
            }
        }
        return maxCount;
    }
}