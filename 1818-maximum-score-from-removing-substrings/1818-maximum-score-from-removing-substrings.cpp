class Solution {
public:
    int maximumGain(string s, int x, int y) {

        stack<char> st;
        int ans = 0;
        char ch1 = 'a', ch2 = 'b';
        int val1 = y, val2= x;
        if(x < y)
        {
            ch1 = 'b';
            ch2 = 'a';
            val1 = x;
            val2 = y;
        }
        ans = calc(s,ch1, ch2, val2, st);
        s = "";
        s.reserve(st.size());
        while (!st.empty()) {
            char ch = st.top();
            s.push_back(ch);
            st.pop();
        }
        reverse(s.begin(), s.end());
        ans = ans + calc(s, ch2, ch1, val1, st);
        return ans;
    }
    int calc (string s, char ch1, char ch2, int val, stack<char>& st)
    {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != ch2) {
                st.push(s[i]);
            } else {
                if (!st.empty() && st.top() == ch1) {
                    ans += val;
                    st.pop();
                }
                else
                {
                    st.push(s[i]);
                }
            }
        }
        return ans;
    }

};