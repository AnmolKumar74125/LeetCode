class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        map<vector<int>,vector<int>> hm;
        vector<vector<string>> ans;
        for(int i = 0; i < strs.size(); i++)
        {
            vector<int> temp(26,0);
            for(int j = 0; j < strs[i].length(); j++)
            {
                temp[strs[i][j] - 97]++;
            }
            if(hm.contains(temp))
            {
                hm[temp].push_back(i);
            }
            else
            {
                vector<int> x;
                x.push_back(i);
                hm[temp] = x;
            }
        }
        
        map<vector<int>,vector<int>>::iterator itr;
        for(itr = hm.begin(); itr != hm.end(); itr++)
        {
            vector<string> temp;
            for(int i = 0; i < itr->second.size(); i++)
            {
                temp.push_back(strs[itr->second[i]]);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};