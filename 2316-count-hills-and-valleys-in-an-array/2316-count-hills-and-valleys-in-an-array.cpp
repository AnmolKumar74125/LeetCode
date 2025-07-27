class Solution {
public:
    int countHillValley(vector<int>& nums) {
        
        int ans = 0, curr = 0;
        for(int i = 1; i < nums.size(); i++)
        {
            if(nums[i] > nums[i-1])
            {
                if(curr == 0)
                {
                    curr = 1;
                    continue;
                }
                if(curr > 0)
                {
                    continue;
                }
                else
                {
                    cout<<"A  i = "<<i<<endl;
                    curr = 1;
                    ans ++;
                }
            }
            else if(nums[i]<nums[i-1])
            {
                if(curr == 0)
                {
                    curr = -1;
                    continue;
                }
                if(curr < 0)
                {
                    continue;
                }
                else
                {
                    cout<<"B  i = "<<i<<endl;
                    curr =  -1;
                    ans++;
                }
            }
        }
        return ans;
    }
};