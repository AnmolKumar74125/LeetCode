class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int target = 0;
        for(int i = 0; i < nums.length; i++)
        {
            target = target | nums[i];
        }
        int ans = cal(nums, 0, nums.length, 0, target);
        return ans;
    }
    public int cal(int nums[], int i, int n, int val, int target)
    {
        int count = 0;
        if(i == n)
        {
            return count;
        }
        int val2 = val | nums[i];
        if(val2 == target)
        {
            count = 1;
        }
        count = count + cal(nums, i+1, n, val2, target);
        count = count + cal(nums, i+1, n, val, target);
        return count;
    }
}