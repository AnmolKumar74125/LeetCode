class Solution {
public:
    int miceAndCheese(vector<int>& reward1, vector<int>& reward2, int k) {
        
        int n = reward1.size();
        vector<int> arr;
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            arr.push_back(reward1[i] - reward2[i]);
            sum += reward2[i];
        }
        sort(arr.begin(), arr.end(),greater<int>());
        for(int i = 0; i < n && i < k; i++)
        {
            sum = sum + arr[i];
        }

        return sum;
    }
};