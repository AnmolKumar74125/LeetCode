class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        vector<unordered_set<int>> row;
        vector<unordered_set<int>> col;
        vector<unordered_set<int>> box;
        for(int i = 0; i < 9; i++)
        {
            row.push_back(unordered_set<int>());
            col.push_back(unordered_set<int>());
            box.push_back(unordered_set<int>());
        }
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(row[i].contains(board[i][j] - 48) || col[j].contains(board[i][j] - 48) || box[(3*(i/3))+(j/3)].contains(board[i][j] - 48))
                {
                    return false;
                }
                
                if( board[i][j] !=  '.')
                {
                    row[i].insert(board[i][j]-48);
                    col[j].insert(board[i][j]-48);
                    box[(3*(i/3))+(j/3)].insert(board[i][j]-48);
                    
                }
            }
        }
        return true;
    }
};