class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        
        int l=0,h=nums.size();
        if(target<nums[0])
        {
            return 0;
        }
        else if(target>nums[h-1])
        {
            return h;
        }
        while(l<h)
        {
            int m=(l+h)/2;
            if(nums[m]==target||(nums[m-1]<target &&nums[m]>target))
            {
                return m;
            }
            else if(nums[m]<target &&nums[m+1]>target)
            {
                return m+1;
            }
            else if(nums[m]>target)
            {
                h=m;
            }
            else if(nums[m]<target)
            {
                l=m+1;
            }
        }
        return 0;
    }
};