class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        
        if ((sum/(float)num > 9))
        {
            return "";
        } 
        string ans = "";
        ans.reserve(num);
        int x = sum / 9;
        for(int i = 1; i <= x; i++)
        {
            sum = sum - 9;
            ans.push_back('9');
        }
        if(sum != 0)
        {
            ans.push_back(48+sum);
        }
        for(int i = ans.length(); i < num; i++)
        {
            ans.push_back('0');
        }
        return ans;
    }
};