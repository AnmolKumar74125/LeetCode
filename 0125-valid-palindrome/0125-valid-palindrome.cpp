class Solution {
public:
    bool isPalindrome(string s) {
        
        int i = 0, j = s.length();
        while(i<=j)
        {
            if((s[i] < 65 || s[i] > 90) && (s[i] < 97 || s[i] > 122) && (s[i] < 48 || s[i] > 57))
            {
                i++;
                continue;
            }
            if((s[j] < 65 || s[j] > 90) && (s[j] < 97 || s[j] > 122) && (s[j] < 48 || s[j] > 57))
            {
                j--;;
                continue;
            }
            if(tolower(s[i]) != tolower(s[j]))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};