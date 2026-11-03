class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int maxVal = nums[0], ans = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            maxVal = max(maxVal, nums[i]);
        }
        for(int i = 0; i < nums.size(); i++)
        {
            ans = ans + (maxVal - nums[i]);
        }
        return ans;
    }
};