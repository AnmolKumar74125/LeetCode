class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int min = nums[0],max = INT_MIN;
        int ans = -1;
        for(int i = 1; i < nums.size(); i++)
        {
            if(nums[i] != min)
            {
                ans = std::max(ans, nums[i] - min);
                min = std::min(min, nums[i]);
            } 
        }
        return ans;
    }
};