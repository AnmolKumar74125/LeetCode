class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int i = 0, j = 0;
        int m = mat.size(), n = mat[0].size();
        vector<int> ans;
        int x = 1;
        int y = 0;

        while(y < (m*n))
        {
            if(i < 0 || j < 0 || i >= m || j >= n)
            {
                break;
            }
            ans.push_back(mat[i][j]);
            cout<<mat[i][j]<<". ";
            if(x == 1)
            {
                i--;
                j++;
            }
            else
            {
                j--;
                i++;
            }
            if(i < 0 || j >= n)
            {
                x = 2;
                i++;
                if(j == n)
                {
                    i++;
                    j--;
                }
            }
            if(j < 0 || i >= m)
            {
                x =1;
                j++;
                if(i == m)
                {
                    i--;
                    j++;
                }
            }
            y++;
        }
        return ans;
    }
};