class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        vector<int> vec(256,-1);
        int ans = 0, count = 0;
        int x = -1;
        for(int i = 0; i < s.length(); i++)
        {
            if(vec[s[i]] > (i-count-1))
            {
                count = i - (vec[s[i]])-1;
            }
            vec[s[i]] = i;
            count++;
            ans = max(ans, count);
        }
        return ans;
    }
};