class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int ans = INT_MAX;
        int i = 0, j = 1;
        int sum = nums[i];
        if(sum >= target)
        {
            return 1;
        }
        while(i < j && j < nums.size())
        {
            sum = sum + nums[j];
            while(sum >= target && i <= j)
            {
                ans = min(ans, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        if(ans == INT_MAX)
        {
            return 0;
        }
        return ans;
    }
};