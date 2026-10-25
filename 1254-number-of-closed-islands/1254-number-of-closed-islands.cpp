class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int ans = 0;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                cout<<grid[i][j]<<" ";
            }
            cout<<endl;
        }
        cout<<endl;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                if(grid[i][j] == 0)
                {
                    if(check(grid, i ,j))
                    {
                        ans ++;
                        cout<<" i = "<<i<<". j = "<<j<<endl;
                    }
                }
            }
        }
        cout<<endl;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                cout<<grid[i][j]<<" ";
            }
            cout<<endl;
        }
        return ans;
    }
    bool check(vector<vector<int>>& grid, int i, int j)
    {
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[i].size())
        {
            return false;
        }
        if(grid[i][j] == 1)
        {
            return true;
        }
        grid[i][j] = 2;
        
        bool val = true;
        int x = 0;
        if(i > 0  && grid[i-1][j] == 2)
        {
            x += 1;
        }
        else
        {
            val = val & check(grid,i-1,j);
        }
        if(j > 0  && grid[i][j-1] == 2)
        {
            x += 1;
        }
        else
        {
            val = val & check(grid,i,j-1);
        }
        if(i < grid.size() - 1 && grid[i+1][j] == 2)
        {
            x += 1;
        }
        else
        {
            val = val & check(grid,i+1,j);
        }
        if(j < grid[i].size() - 1 && grid[i][j+1] == 2)
        {
            x += 1;
        }
        else
        {
            val = val & check(grid,i,j+1);
        }
        if(x == 0)
        {
            //return false;
        }
        return val;
        /*
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[i].size())
        {
            return false;
        }
        if(grid[i][j] == 1 || grid[i][j] == 2)
        {
            return true;
        }
        grid[i][j] = 2;
        
        bool val = true;
        return (check(grid,i-1,j) && check(grid, i, j-1) && check(grid, i, j+1) && check(grid, i+1, j));
        */
    }
};