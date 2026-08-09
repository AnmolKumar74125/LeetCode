class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        
        vector<int> ans(2,-1);
        int i = 0, j = numbers.size() - 1;
        while(i < j)
        {
            int x = numbers[i] + numbers[j];
            if(x == target)
            {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
            else if(x > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
};