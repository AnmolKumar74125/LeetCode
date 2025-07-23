class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<vector<int>> back;
        vector<int> max_arr(26,0);
        vector<int> ans;
        for(int i = 0; i < s.length(); i++)
        {
            back.push_back(vector(26,0));
        }
        back[s.length() - 1][s[s.length() - 1] - 97] = 1;
        for(int i = 1; i < s.length(); i++)
        {
            back[s.length() - 1 - i] = back[s.length() - i];
            back[s.length() - 1 - i][s[s.length() - i - 1] - 97]++;
        }
        
        max_arr = back[0];
        int last = -1;
        vector<int> curr(26,0);
        for(int i = 0; i < s.length(); i++)
        {
            bool f = true;
            curr[s[i]-97]++;
            if(max_arr[s[i]-97] == curr[s[i]-97])
            {
                for(int j = 0; j < 26; j++)
                {
                    if((curr[j] > 0 && back[i][j] != 0) &&  j != s[i]- 97)
                    {
                        f = false;
                    }
                }
                if(f == true)
                {
                    ans.push_back(i - last);
                    last = i;
                }
            }

        }
        return ans;
    }
};