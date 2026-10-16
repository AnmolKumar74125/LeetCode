class Solution {
public:
    int scoreOfParentheses(string s) {
        
        stack<char> st;
        int ans = 0;
        int current = 0;
        bool take = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == '(')
            {
                current++;
                take = true;
                continue;
            }
            else
            {
                current--;
                if(take == true)
                {
                    ans = ans + pow(2,current);
                }
                take = false;
            }
        }
        return ans;
    }
};