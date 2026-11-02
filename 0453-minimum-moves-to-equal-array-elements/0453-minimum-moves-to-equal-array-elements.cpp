class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int ans = 0;
        if(nums.size() == 1)
        {
            return ans;
        }
        sort(nums.begin(),nums.end());
        for(int i = 1; i < nums.size(); i++)
        {
            nums[i] = nums[i] + ans;
            ans = ans + abs(nums[i] - nums[i-1]);
        }
        return ans;
    }
};