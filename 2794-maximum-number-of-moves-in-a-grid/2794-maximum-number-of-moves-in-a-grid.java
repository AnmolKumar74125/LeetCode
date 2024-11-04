class Solution {
    public int maxMoves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int mat[][] = new int[m][n];
        for(int i = 1; i < n; i++)
        {
            int f = 0;
            for(int j = 0; j < m;  j++)
            {
                int currMax = 0;
                if((j > 0) && (grid[j-1][i-1] < grid[j][i]) && (i == 1 || mat[j-1][i-1] > 0))
                {
                    f = 1;
                    currMax = Math.max(currMax, mat[j-1][i-1] + 1);
                }
                if((grid[j][i-1] < grid[j][i]) && (i == 1 || mat[j][i-1] > 0))
                {
                    f = 1;
                    currMax = Math.max(currMax, mat[j][i-1] + 1);
                }
                if((j < m-1) && (grid[j+1][i-1] < grid[j][i]) && (i == 1 || mat[j+1][i-1] > 0))
                {
                    f = 1;
                    currMax = Math.max(currMax, mat[j+1][i-1] + 1);
                }
                mat[j][i] = currMax;
                ans = Math.max(currMax, ans);
            }
            if(f == 0)
            {
                return ans;
            }
        }
        return ans;
    }
}