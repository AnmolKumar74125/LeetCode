class Solution {
public:
    bool canPartition(vector<int>& nums) {

        int sum = 0, n = nums.size();
       for(int i = 0; i < n; i++)
       {
            sum += nums[i];
       } 
       if(sum % 2 != 0)
       {
            return false;
       }
       sum = sum/2;
       bool arr[n + 1][sum + 1];
       
       for(int i = 0; i <= n; i++)
       {
            arr[i][0] = true;
       }
       for(int i = 1; i <= sum; i++)
       {
            arr[0][i] = false;
       }
       for(int i = 1 ; i <= n; i++)
       {
            for(int j = 1; j <= sum; j++)
            {
                arr[i][j] = arr[i-1][j];
                if(j  >= nums[i-1])
                {
                    arr[i][j] = (arr[i-1][j] || arr[i-1][j-nums[i-1]]);
                }
            }
       }
       return (arr[n][sum]==1)?true:false;
    }
};