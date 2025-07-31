class Solution {
public:
    int maximumLength(vector<int>& nums, int k) {

        vector<vector<int>> arr(k + 1, vector<int>(nums.size(), 1));
        int ans = 0;
        for (int j = 1; j < nums.size(); j++) {
            for (int l = j - 1; l >= 0; l--) {
                int i = (nums[l] + nums[j]) % k;
                arr[i][j] = max(arr[i][j], arr[i][l] + 1);
                ans = std::max(ans, arr[i][j]);
            }
        }
    

    return ans;
}
}
;