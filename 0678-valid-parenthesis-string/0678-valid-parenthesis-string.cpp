class Solution {
public:
    bool checkValidString(string s) {
        if(checkfront(s) && checkback(s))
        {
            return true;
        }        
        return false;
    }
    bool checkfront(string s)
    {

        int starCount =0;
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == '(')
            {
                count++;
            }
            else if(s[i] == '*')
            {
                starCount++;
            }
            else
            {
                if(count > 0)
                {
                    count--;
                }
                else if(starCount > 0)
                {
                    starCount--;
                }
                else
                {
                    return false;
                }
            }
        }
        if(count == 0 || count - starCount ==0);
        return true;

        return false;
    }
    bool checkback(string s)
    {

        int starCount =0;
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s[i] == ')')
            {
                count++;
            }
            else if(s[i] == '*')
            {
                starCount++;
            }
            else
            {
                if(count > 0)
                {
                    count--;
                }
                else if(starCount > 0)
                {
                    starCount--;
                }
                else
                {
                    return false;
                }
            }
        }
        if(count == 0 || count - starCount ==0);
        return true;

        return false;
    }
};