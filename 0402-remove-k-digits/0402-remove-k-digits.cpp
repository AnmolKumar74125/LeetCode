class Solution {
public:
    string removeKdigits(string num, int k) {
        
        stack<char> st;
        for(int i =0 ; i< num.length(); i++)
        {
            while(!st.empty())
            {
                if(st.top() > num[i] && k > 0)
                {
                    st.pop();
                    k--;
                }
                else
                {
                    break;
                }
            }
            st.push(num[i]);
        }
        string ans = "";
        while(!st.empty())
        {
            if(k > 0)
            {
                k--;
                st.pop();
                continue;
            }
            ans.push_back(st.top()); 
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        int x = 0;
        for(int i = 0;i < ans.length(); i++)
        {
            if(ans[i] != '0')
            {
                break;
            }
            x++;
        }
        if(ans.length() == x || ans.length() == 0 )
        {
            return "0";
        }
        return ans.substr(x);
    }
};