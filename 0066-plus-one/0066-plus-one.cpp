class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
        bool f = false;
        int i = 0;
        for(i = digits.size()-1; i >= 0; i--)
        {
            if(digits[i] == 9)
            {
                digits[i] = 0;
                continue;
            }
            else
            {
                f = true;
                digits[i]++;
                break;
            }
        }
        if(!f && i < 0)
        {
            digits.insert(digits.begin(),1);
        }
        return digits;
    }
};