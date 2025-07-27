class Solution {
public:
    int countHillValley(vector<int>& nums) {
        
        int ans = 0, curr = 0;
        for(int i = 1; i < nums.size(); i++)
        {
            if(nums[i] > nums[i-1])
            {
                if(curr < 0)
                {
                    ans ++;
                }
                curr = 1;
            }
            else if(nums[i]<nums[i-1])
            {
                if(curr > 0)
                {
                    ans++;
                }
                curr =  -1;
            }
        }
        return ans;
    }
};