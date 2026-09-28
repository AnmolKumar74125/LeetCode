class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int rep = k;
        int count = 1, ans = 1;
        int i = 0, j = 1;
        int n = s.length();
        char currChar = s[0];
        while(j < n)
        {
            if(s[j] == currChar)
            {
                count++;
            }
            else if(rep > 0)
            {
                count++;
                rep--;
            }
            else
            {
                ans = max(ans,count);
                //cout<<"A count = "<<count<<". ans = "<<ans<<endl;
                currChar = s[j];
                count = 1;
                i = j - 1;
                rep = k;
                while( i >= 0)
                {
                    if(s[i] == currChar)
                    {
                        count++;
                    }
                    else if(rep > 0)
                    {
                        count++;
                        rep--;
                    }
                    else
                    {
                        break;
                    }
                    i--;
                }
            }
            //cout<<"B count = "<<count<<". ans = "<<ans<<endl;
            ans = max(ans,count);
            j++;
        }
        return ans;
    }
};