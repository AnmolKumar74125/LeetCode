class Solution {
public:
    int minimumOperations(vector<int>& nums) {

        map<int,int> hm;
        int ans = 0, last = -1;
        for(int i = 0; i < nums.size(); i++)
        {
            //print_map(hm);
            cout<<endl;
            if(hm.count(nums[i]) > 0)
            {
                if(hm[nums[i]] >= last)
                {
                    int x = (hm[nums[i]] / 3) + 1;
                    last = x * 3;
                    ans = x;
                }
            }
            hm[nums[i]] = i;
        }
        return ans;
    }
    void print_map(map<int,int>& hm)
    {
        for(auto i : hm)
        {
            cout << i.first <<" : "<<i.second<<endl;
        }
    }
};