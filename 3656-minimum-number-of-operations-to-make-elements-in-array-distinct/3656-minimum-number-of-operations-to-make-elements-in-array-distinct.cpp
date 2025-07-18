class Solution {
public:
    int minimumOperations(vector<int>& nums) {

        map<int,int> hm;
        int last = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            if(hm.count(nums[i]) > 0)
            {
                if(hm[nums[i]] >= last)
                {
                    int x = (hm[nums[i]] / 3) + 1;
                    last = x * 3;
                }
            }
            hm[nums[i]] = i;
        }
        return last / 3;
    }
};