class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        
        set<int> hs;
        for(int i = 0; i< nums.size(); i++)
        {
            if(hs.contains(nums[i]))
            {
                return true;
            }
            hs.insert(nums[i]);
        }
        return false;
    }
};