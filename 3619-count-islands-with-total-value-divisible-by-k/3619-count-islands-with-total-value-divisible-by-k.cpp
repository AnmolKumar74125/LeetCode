class Solution {
public:
    int countIslands(vector<vector<int>>& grid, int k) {
        int ans = 0;
        long long sum = 0;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                if(grid[i][j] != 0 && grid[i][j] != -1)
                {
                    check(grid, i, j, &sum);
                    cout<<"i = "<<i<<" j = "<<j<<". sum = "<<sum<<endl;
                    if(sum %k == 0)
                    {
                        ans++;
                    }
                    sum = 0;
                }
            }
        }
        return ans;
    }
    void check(vector<vector<int>>& grid, int i, int j, long long* sum)
    {
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[i].size())
        {
            return;
        }
        if(grid[i][j] == 0 || grid[i][j] == -1)
        {
            return;
        }
        *sum = *sum + grid[i][j];
        grid[i][j] = -1;
        check(grid,i-1,j,sum);
        check(grid,i,j-1,sum);
        check(grid,i+1,j,sum);
        check(grid,i,j+1,sum);
        
        return ;
    }
};