class Solution {
public:
    int maximumLength(vector<int>& nums) {
        
        int even = 0, odd = 0,evenodd = 0, oddeven = 0;
        int x = 0, y = 1;
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] % 2 == 0)
            {
                even++;
                if(x == 0)
                {
                    evenodd++;
                    x = 1;
                }
                if(y == 0)
                {
                    oddeven++;
                    y = 1;
                }
            }
            else
            {
                odd++;
                if(x == 1)
                {
                    evenodd++;
                    x = 0;
                }
                if(y == 1)
                {
                    oddeven++;
                    y = 0;
                }
            }
        }
        return max(max(even , odd),max(evenodd,oddeven));
    }
};