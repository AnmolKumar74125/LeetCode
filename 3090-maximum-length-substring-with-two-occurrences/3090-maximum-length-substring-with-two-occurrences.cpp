class Solution {
public:
    int maximumLengthSubstring(string s) {
        
        vector<int> arr(26,0);
        int i = 0, j = 0;
        int ans = 0;
        while(i <= j && j < s.length())
        {
            arr[s[j]-97]++;
            while(arr[s[j]-97] > 2 && i<=j)
            {
                arr[s[i]-97]--;
                i++;
            }
            ans = max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
};