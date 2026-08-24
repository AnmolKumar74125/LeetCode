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
                cout<<board[i][j]<<" ";
            }
            cout<<endl;
        }
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {

                //cout<< board[i][j]<<endl;
               // if(row[i].contains(board[i][j] - 48) || col[i].contains(board[i][j] - 48) || box[(3*(i/3))+(j/3)].contains(board[i][j] - 48))
                if(row[i].contains(board[i][j] - 48))
                {
                    cout<<"A"<<i <<". "<< j <<endl;
                    return false;
                }
                if(col[j].contains(board[i][j] - 48))
                {
                    cout<<"B"<<i <<". "<< j <<endl;
                   // break;
                    return false;
                }

                if(box[(3*(i/3))+(j/3)].contains(board[i][j] - 48))
                {
                    cout<<"C"<<i <<". "<< j <<endl;
                    return false;
                }
                if( board[i][j] !=  '.')
                {
                    row[i].insert(board[i][j]-48);
                    col[j].insert(board[i][j]-48);
                    box[(3*(i/3))+(j/3)].insert(board[i][j]-48);
                    cout<<i <<". "<<j<<endl;
                    cout<<"box = "<<(3*(i/3))+(j/3)<<endl;
                }
            }
        }
        for(int i = 0; i < 9; i++)
        {
            //cout<< "row" <<(i+1)<<" = ";
            //print(row[i]);
            //cout<< "col" <<(i+1)<<" = ";
            //print(col[i]);
            cout<< "box" <<(i+1)<<" = ";
            print(box[i]);
        }
        return true;
    }
    void print(unordered_set<int> hs)
    {
        unordered_set<int>::iterator itr;
        for(itr = hs.begin(); itr != hs.end(); itr++)
        {
            cout << *itr << " ";
        }
        cout<<endl;
    }
};