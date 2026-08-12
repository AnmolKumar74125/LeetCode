class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> arr(2*10000 + 1, 0);
        for(int i = 0; i < 2*10000 + 1; i++)
        {
            arr[i] = i;
        }

        for(int i = 0; i < nums.size(); i++)
        {
            arr[nums[i] + 10000 + 1] += 100000;
        }
        sort(arr.begin(), arr.end());
        reverse(arr.begin(), arr.end());
        vector<int> ans;
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr[i] /100000 > 0)
            {
                ans.push_back(arr[i]%100000 - 10001);
                k--;
                cout<< arr[i] << endl;
            }
            if(k == 0)
            {
                break;
            }
        }
        return ans;
    }
};