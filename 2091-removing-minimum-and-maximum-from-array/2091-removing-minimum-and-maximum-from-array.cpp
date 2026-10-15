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
        cout << "minPos = "<<minPos<<". maxPos = "<<maxPos<<endl;
        cout<<"(minPos + maxPos + 2) = "<<(minPos + maxPos + 2)<<endl;
        cout<<"(n - minPos) + (n - maxPos) = "<<(n - minPos) + (n - maxPos)<<endl;
        cout<<"(maxPos + (n - minPos))"<<(maxPos + (n - minPos))<<endl;
        cout<<"(minPos + (n - maxPos))"<<(minPos + (n - maxPos))<<endl;
        int ans = min(min((max(minPos, maxPos) + 1),max((n - minPos) , (n - maxPos))), min((maxPos + 1 + (n - minPos)), (minPos + 1+ (n - maxPos))));
        return ans;
    }
};