class Solution {
public:
    int maximumSwap(int num) {
        
        int p = num;
        vector<int> arr;
        arr.push_back(0);
        string s = "";
        while(p != 0)
        {
            int r = p%10;
            s.push_back((char)(r+48));
            arr.push_back(max(r,arr[arr.size()-1]));
            p = p/10;
        }
        reverse(arr.begin(),arr.end());
        reverse(s.begin(),s.end());
        int pos1 = -1,v1 = -1, x = -1;
        for(int i = 0; i < s.length(); i++)
        {
            if(((int)(s[i]) - 48) < arr[i+1])
            {
                pos1 = i;
                v1 = arr[i+1];
                x = ((int)(s[i])-48);
                break;
            }
        }
        string w = "";
        bool f = false;
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(((int)(s[i])-48) == v1 && f==false)
            {
                w = (char)(x + 48) + w;
                f = true;
                continue;
            }
            if(i == pos1)
            {
                w = (char)(v1 + 48) + w;
                continue;
            }
            w = s[i] + w;
        }
        for(int i = 0; i < w.length(); i++)
        {
            ans =ans * 10 + (int)(w[i] - 48);   
        }
        return ans;
    }
};