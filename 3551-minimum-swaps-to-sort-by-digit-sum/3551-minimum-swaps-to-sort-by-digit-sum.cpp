class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        vector<long long> dsum(nums.size(),0);
        vector<long long> sorted_dsum(nums.size(),0);
        unordered_map<long long,int> hm;
        const long long MULTIPLIER = 1000000000LL; 
        for(int i = 0; i < nums.size(); i++)
        {
            //string r = to_string(getdsum(nums[i])) + "_"+to_string(nums[i]);
            long long r = (1LL * getdsum(nums[i]) * MULTIPLIER) + nums[i];
            dsum[i] = r;
            sorted_dsum[i] = r;
            hm[r] = i;
        }
       // sort(sorted_dsum.begin(),sorted_dsum.end());
        // Sort based on the 'a' part (before the underscore)
/*
        std::sort(sorted_dsum.begin(), sorted_dsum.end(), [](const std::string& s1, const std::string& s2) {
            // Find the position of the underscore
            auto pos1 = s1.find('_');
            auto pos2 = s2.find('_');

            // Extract the 'a' part
            int a1 = stoi(s1.substr(0, pos1));
            int a2 = stoi(s2.substr(0, pos2));
            int b1 = stoi(s1.substr(pos1 + 1));
            int b2 = stoi(s2.substr(pos2 + 1));
            // Compare the 'a' parts lexicographically
            if(a1 < a2)
            {
                return true;
            }
            else if(a1 == a2)
            {
                if(b1 < b2)
                {
                    return true;
                }
            }
            return false;
        });
*/
        sort(sorted_dsum.begin(), sorted_dsum.end());
        /*
        for(int i = 0; i < sorted_dsum.size(); i++)
        {
            hm[dsum[i]] = i;
        }
        */
        int ans = 0;
       /*
        for(int i = 0; i < dsum.size(); i++)
        {
            cout<<"i = "<<i<<" dsum[i] = "<<dsum[i]<<"  sorted_dsum[i] = "<<sorted_dsum[i]<<endl;  
        }
        */
        for(int i = 0; i < nums.size(); i++)
        {
            if(dsum[i] != sorted_dsum[i])
            {
                long long temp = dsum[i];
                //cout <<"hm[sorted_dsum[i]] = "<<hm[sorted_dsum[i]]<<endl;
                dsum[hm[sorted_dsum[i]]] = temp;
                dsum[i] = sorted_dsum[i];
                hm[temp] = hm[sorted_dsum[i]];
                ans++;
            } 
           /* for(int i = 0; i < dsum.size(); i++)
            {
                cout<<"i = "<<i<<" dsum[i] = "<<dsum[i]<<endl;  
            }*/
            //cout << endl;
        }
       /*
        for(int i = 0; i < dsum.size(); i++)
        {
            cout<<"i = "<<i<<" dsum[i] = "<<dsum[i]<<endl;  
        }
        */
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