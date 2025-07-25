class Solution {
public:
    int maxSum(vector<int>& nums) {
        
        int max = INT_MIN;
        int sum = 0;
        set<int> hs;
        for(int i = 0; i < nums.size(); i++)
        {
            if(!hs.contains(nums[i]) && nums[i]>0)
            {
                sum = sum+nums[i];
                hs.insert(nums[i]);
            }
            max = std::max(max, nums[i]);
        }
        if(sum == 0)
        {
            return max;
        }
        return sum;
    }
};