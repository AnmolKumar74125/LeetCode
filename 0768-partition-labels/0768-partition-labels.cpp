class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<vector<int>> front;
        vector<vector<int>> back;
        vector<int> max_arr(26,0);
        vector<int> ans;
        for(int i = 0; i < s.length(); i++)
        {
            front.push_back(vector(26,0));
            back.push_back(vector(26,0));
        }
        front[0][s[0]-97] = 1;
        back[s.length() - 1][s[s.length() - 1] - 97] = 1;
        for(int i = 1; i < s.length(); i++)
        {
            front[i] = front[i-1];
            //front[i][s[i]-97] = front[i - 1][s[i] - 97] + 1;
            front[i][s[i]-97] = front[i][s[i] - 97] + 1;
            back[s.length() - 1 - i] = back[s.length() - i];
            //back[s.length() - 1 - i][s[s.length() - 1] - 97] = back[s.length() - i][s[s.length() - 1] - 97] + 1;
            back[s.length() - 1 - i][s[s.length() - i - 1] - 97]++;
        }

        #if 0
        for(int i = 0; i < s.length(); i++)
        {
            cout<<s[i]<<" == Front = ";
            for(int j = 0; j < 26; j++)
            {
                cout << front[i][j] <<" ";
            }
            cout<<endl <<s[i]<< " == Back = ";
            for(int j = 0; j < 26; j++)
            {
                cout << back[i][j] <<" ";
            }
            cout<<endl;
        }
        #endif
        max_arr = front[s.length() - 1];
        int last = -1;
        for(int i = 0; i < s.length(); i++)
        {
            bool f = true;
            //cout<<"max_arr[ "<<(s[i] - 97) <<"] = " <<max_arr[s[i]-97]<<endl; 
            if(max_arr[s[i]-97] == front[i][s[i]-97])
            {
                for(int j = 0; j < 26; j++)
                {
                    if((front[i][j] > 0 && back[i][j] != 0) &&  j != s[i]- 97)
                    {
                        //cout<< " case false for i = "<<i<<"  j = "<< j<<endl;
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