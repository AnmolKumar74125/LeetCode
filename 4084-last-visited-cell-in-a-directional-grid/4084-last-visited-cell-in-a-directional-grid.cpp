class Solution {
public:
    vector<int> lastVisitedCell(vector<vector<char>>& grid) {

        vector<int> ans(2,0);
        int i = 0, j = 0;
        int m = grid.size(), n = grid[0].size();
        while(true)
        {
            //cout <<" i = "<<i<<" j = "<<j<<". grid[i][j] = "<<grid[i][j]<<endl;
            char temp = grid[i][j];
            grid[i][j] = ' ';
            if(temp == 'R' && j < n-1 && grid[i][j+1] != ' ')
            {
                ans[1] = ++j;
            }
            else if(temp == 'D' && i < m-1 && grid[i+1][j] != ' ')
            {
                ans[0] = ++i;
            }
            else if(temp == 'L' && j > 0 && grid[i][j-1] != ' ')
            {
                ans[1]= --j;
            }
            else if(temp == 'U' && i > 0 && grid[i-1][j] != ' ')
            {
                ans[0] = --i;
            }
            else
            {
                return ans;
            }
        }
        return ans;   
    }
};