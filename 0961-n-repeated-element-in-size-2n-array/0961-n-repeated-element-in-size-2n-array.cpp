class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {

        unordered_set<int> hs;
        for(int i = 0; i< nums.size(); i++)
        {
            if(hs.contains(nums[i]))
            {
                return nums[i];
            }
            hs.insert(nums[i]);
        }   
        return -1;
    }
};