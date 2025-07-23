class Solution {
public:
    int findMaxFish(vector<vector<int>>& grid) {
        
        int ans = 0;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                ans = max(ans, calc(grid, i, j));
            }
        }
        return ans;
    }
    int calc(vector<vector<int>>& grid, int i, int j)
    {
        if(grid[i][j] == 0)
        {
            return 0;
        }
        int ans = grid[i][j];
        grid[i][j] = 0;
        if(i > 0)
        {
            //i - 1
            ans = ans + calc(grid, i - 1, j);
        }
        if(j > 0)
        {
            //j - 1
            ans = ans + calc(grid, i, j - 1);
        }
        if(i < grid.size() - 1)
        {
            //i + 1
            ans = ans + calc(grid, i + 1, j);
        }
        if(j < grid[i].size() - 1)
        {
            ans = ans + calc(grid, i, j + 1);
        }
        return ans;
    }
};