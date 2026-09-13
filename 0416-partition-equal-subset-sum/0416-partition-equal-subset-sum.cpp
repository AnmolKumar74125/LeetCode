class Solution {
public:
    bool canPartition(vector<int>& nums) {

        int sum = 0, n = nums.size();
       for(int i = 0; i < n; i++)
       {
            sum += nums[i];
       } 
       if(sum % 2 != 0)
       {
            return false;
       }
       sum = sum/2;
       vector<bool> arr;
       arr.push_back(true);
       for(int i = 1; i <= sum; i++)
       {
            arr.push_back(false);
       }
       vector<bool> tmp;
       tmp = arr;
       for(int i = 0 ; i < n; i++)
       {
            for(int j = 1; j <= sum; j++)
            {
                if(j  >= nums[i])
                {
                    arr[j] = (tmp[j] || tmp[j-nums[i]]);
                }
            }
            tmp = arr;
       }
       return arr[sum];
    }
};