class Solution {
public:
    int maxSum(vector<int>& nums, int k) {
        vector<int> arr(32,0);
        long long ans = 0;
        int x = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            int j = 0;
            int p = nums[i];
            //cout << (nums[i] >> j)<< "   "<<((nums[i] >> j) & 1)<<endl;
            while(j < 32 && p > 0)
            {
                if((nums[i] >> j) & 1 >= 1)
                {
                    arr[j]++;
                    x = max(x, arr[j]);
                }
                p = p >> 1; 
                j++;
            }
        }
      /*
        for(int i = 0; i < 32; i++)
        {
            cout << " arr["<<i<<"] = "<<arr[i]<<endl;
        }
        */
        int i = 0;
        while(i < k && x != 0)
        {
            x = 0;
            int val = 0;
            for (int j = 31; j >= 0; j--) 
            {
                if(arr[j] > 0)
                {
                    val = val + pow(2,j);
                    arr[j]--;
                    x = arr[j] > 0 ? 1:x;
                }
            }
            //cout << "val = "<<val<<endl;
            ans = (ans + (((long long)val * val) % 1000000007))%1000000007;
            i++;
        }
        return (int)ans;
    }
};