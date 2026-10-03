class Solution {
public:
    int longestValidParentheses(string s) {
        
        stack<int> st;
        int count = 0, ans = 0;
        int lastSize = -1;
        st.push(-1);
        for(int i = 0; i< s.length(); i++)
        {
            if(s[i] == '(')
            {
                st.push(i);
            }
            else
            {
                if(!st.empty())
                {
                    if(st.top() == -1)
                    {
                        st.push(i);
                        continue;
                    }
                    if(s[st.top()] == '(')
                    {
                        st.pop();
                        ans = max(ans, i - st.top());
                        
                    }
                    else
                    {
                        st.push(i);
                    }
                }
            }
        }
        return ans;
    }
};