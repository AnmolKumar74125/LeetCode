class Solution {
public:
    int sortPermutation(vector<int>& nums) {
        
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        int k = -1; 
        for(int i = 0; i< nums.size(); i++)
        {
            if(nums[i] != sorted[i])
            {
                if(k == -1)
                {
                    k = (nums[i] & sorted[i]);
                }
                k = k & (nums[i] & sorted[i]);
            }
        }
        if(k == -1)
        {
            return 0;
        }
        return k;
    }
};