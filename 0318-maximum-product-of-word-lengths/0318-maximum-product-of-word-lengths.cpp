class Solution {
public:
    int maxProduct(vector<string>& words) {
        
        vector<int> vec;
        for(int i = 0; i < words.size();i++)
        {
            int x = 0;
            for(int j = 0; j < words[i].length(); j++)
            {
                x = x | (1 << ((int)words[i][j] - 97));
            }
            vec.push_back(x);
            cout<<x<<" ";
        }
        int ans = 0;
        for(int i = 0;i < vec.size(); i++)
        {
            for(int j = i+1;j < vec.size(); j++)
            {
                if((vec[i] & vec[j]) == 0)
                {
                    ans = max(ans, (int)(words[i].length() * words[j].length()));
                }
            }
        }
        cout <<endl;
        return ans;
    }
};
/*
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 
a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
*/