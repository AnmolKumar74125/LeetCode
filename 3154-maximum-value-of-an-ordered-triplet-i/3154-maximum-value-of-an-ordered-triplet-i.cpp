class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        long long ans = 0;
        for(int i = nums.size() - 1; i > 1; i--)
        {
            for(int j = i-1 ; j >= 1; j--)
            {
                for(int k = j -1; k >=0; k--)
                {
                    ans = std::max(ans, (1LL*(nums[k] - nums[j]) * nums[i]));
                }
            }
        }
        return ans;
    }
};