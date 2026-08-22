class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        
        vector<int> arr;
        arr.push_back(nums[0]);
        for(int i = 1; i < nums.size() - 1; i++)
        {
            arr.push_back(arr[i-1]*nums[i]);
        }
        arr.push_back(arr[nums.size()-2]);

        for(int i = nums.size()-2; i >= 1; i--)
        {
            arr[i] = arr[i-1] * nums[i+1];
            nums[i] = nums[i]*nums[i+1];
        }
        arr[0] = nums[1];
        return arr;
    }
};