class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int minVal = INT_MAX, maxVal = INT_MIN, minPos = -1, maxPos = -1;
        int n = nums.size();
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < minVal)
            {
                minVal = nums[i];
                minPos = i;
            }
            if(nums[i] > maxVal)
            {
                maxVal = nums[i];
                maxPos = i;
            }
        }
        int ans = min(min((max(minPos, maxPos) + 1),max((n - minPos) , (n - maxPos))), min((maxPos + 1 + (n - minPos)), (minPos + 1+ (n - maxPos))));
        return ans;
    }
};