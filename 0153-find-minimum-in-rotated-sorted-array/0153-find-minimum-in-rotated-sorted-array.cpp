class Solution {
public:
    int findMin(vector<int>& nums) {
        
        int i = 0, j = nums.size()-1;
        if(nums.size() == 1 || nums[i] < nums[j])
        {
            return nums[0];
        }
        if(nums[j] < nums[j-1])
        {
            return nums[j];
        }
        int arr_0 = nums[0];
        int arr_n = nums[j];
        i++;
        j--;
        while(i>0 && j < nums.size() && i<=j)
        {
            int mid = (i + j) / 2;
            cout << i <<". "<<j<<". "<<mid<<endl;
            if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])
            {
                return nums[mid];
            }
            else if(nums[mid] > arr_n)
            {
                i = mid + 1;
            }
            else if(nums[mid] < arr_n)
            {
                j = mid;
            }
        }
        return -1;
    }
};