class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
         
        map<int,int> hm;
        vector<int> arr(2);
        for(int i = 0; i < nums.size(); i++)
        {
            if(hm.contains(target - nums[i]))
            {
                arr[0] = i;
                arr[1] = hm[target - nums[i]];
                return arr;
            }
            else
            {
                hm[nums[i]] = i;
            }
        }
        return arr;
    }
};