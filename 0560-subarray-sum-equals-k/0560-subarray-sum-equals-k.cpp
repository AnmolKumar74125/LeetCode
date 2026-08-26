class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        unordered_map<int, int> hm;
        hm[0]= 1;
        int sum = 0, ans = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            sum = sum + nums[i];
            if(hm.contains(sum - k))
            {
                ans = ans + hm[sum-k];
            }
            if(hm.contains(sum))
            {
                hm[sum]++;;
            }
            else
            {
                hm[sum]= 1;
            }
        }
        return ans;
    }
};