class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_map<int, int> hm;
        for(int i = 0; i < nums.size(); i++)
        {
            hm[nums[i]] = 1;
        }

        int ans = 0;
       // printMap(hm);
       // cout<<endl;
        unordered_map<int,int>::iterator itr;
        for(itr = hm.begin(); itr != hm.end(); itr++)
        {
            int k = itr->first;
            while(hm.contains(k - 1) && hm[k-1] != -1)
            {
                hm[itr->first] += hm[--k] ;
                //k--;
                hm[k] = -1;
                //cout<<k<<".   "<<itr->first<<" -> "<<hm[itr->first]<<endl;
            }
            ans = max(ans, hm[itr->first]);
        }
        //printMap(hm);
        return ans;
    }
    void printMap(unordered_map<int, int> hm)
    {
        unordered_map<int,int>::iterator itr;
        for(itr = hm.begin(); itr != hm.end(); itr++)
        {
            cout<<itr->first<<" -> "<<itr->second<<endl;
        }
    }
};