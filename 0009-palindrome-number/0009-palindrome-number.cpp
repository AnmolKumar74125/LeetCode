class Solution {
public:
    bool isPalindrome(int x) {
        
        int n = x;
        long long p = 0;
        while(x > 0)
        {
            p = p * 10 + (x%10);
            x = x /10;
        }
        if(p == n)
        {
            return true;
        }
        return false;
    }
};