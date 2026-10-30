class Solution {
public:
    int rob(vector<int>& nums) {
     int n=nums.size();
        int mat[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            mat[i][0]=0;
            mat[0][i]=0;
            if(i!=0)
            {
                mat[i-1][0]=nums[i-1];
                mat[1][i]=nums[0];
            }
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=2;j<=n;j++)
            {
                mat[i][j]=max(mat[i-2][j-1]+nums[i-1],mat[i-1][j-1]);
            }
        }
        return mat[n][n];   
    }
};