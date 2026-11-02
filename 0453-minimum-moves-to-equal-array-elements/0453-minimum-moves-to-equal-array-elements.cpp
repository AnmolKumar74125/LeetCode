class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int ans = 0;
        int minVal = nums[0];
        for(int i = 0; i < nums.size(); i++)
        {
            minVal = min(minVal, nums[i]);
        }
        for(int i = 0; i < nums.size(); i++)
        {
            ans += (nums[i] - minVal);
        }
        return ans;
    }
};