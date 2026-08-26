class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        unordered_map<int, vector<int>> hm;
        vector<int> temp;
        temp.push_back(-1);
        hm[0]= temp;
        int sum = 0, ans = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            sum = sum + nums[i];
            if(hm.contains(sum - k))
            {
                ans = ans + hm[sum-k].size();
            }
            if(hm.contains(sum))
            {
                hm[sum].push_back(i);
            }
            else
            {
                vector<int> tmp;
                tmp.push_back(i);
                hm[sum]= tmp;
            }
        }
        return ans;
    }
};