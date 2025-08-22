class Solution {
public:
    int minimumArea(vector<vector<int>>& grid) {
             
        int minr = INT_MAX, minc = INT_MAX;
        int maxc = 0, maxr = 0;
        int m = grid.size();
        int n = grid[0].size();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    minr = min(minr, i);
                    minc = min(minc, j);
                    maxr = max(maxr, i);
                    maxc = max(maxc, j);
                }
            }
        }

        return (maxr - minr + 1) * (maxc - minc + 1);
    }
};