class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        vector<long long> dsum(nums.size(),0);
        vector<long long> sorted_dsum(nums.size(),0);
        unordered_map<long long,int> hm;
        const long long MULTIPLIER = 1000000000LL; 
        for(int i = 0; i < nums.size(); i++)
        {
            long long r = (1LL * getdsum(nums[i]) * MULTIPLIER) + nums[i];
            dsum[i] = r;
            sorted_dsum[i] = r;
            hm[r] = i;
        }
 
        sort(sorted_dsum.begin(), sorted_dsum.end());

        int ans = 0;

        for(int i = 0; i < nums.size(); i++)
        {
            if(dsum[i] != sorted_dsum[i])
            {
                long long temp = dsum[i];
                dsum[hm[sorted_dsum[i]]] = temp;
                dsum[i] = sorted_dsum[i];
                hm[temp] = hm[sorted_dsum[i]];
                ans++;
            } 

        }

        return ans;
    }
    int getdsum(int n)
    {
        int r = 0;
        while(n > 0)
        {
            r = r +(n%10);
            n = n/10;
        }
        return r;
    }
};