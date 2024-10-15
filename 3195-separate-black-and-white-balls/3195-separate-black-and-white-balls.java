class Solution {
    public long minimumSteps(String s) {
        
        long ans = 0;
        int tw = 0, tb = 0, pb = 0, pw = 0;
        int n = s.length();;
        char ch[] = s.toCharArray();
        for(int i = 0; i < n; i++)
        {
            if(ch[i] == '0')
            {
                tw++;
                continue;
            }
            tb++;
        }
        int i = tw - 1, j = tw;
        while(true)
        {
            while(i >=0 && ch[i] != '1')
            {
                pw++;
                i--;
            }
            while(j < n && ch[j] != '0')
            {
                pb++;
                j++;
            }
            if(i < 0 || j >= n || pw == tw || pb == tb)
            {
                break;
            }
            ans = ans + (j - i);
            ch[i] = '0';
            ch[j] = '1'; 
            pb++;
            pw++;
            j++;
            i--;
        }
        return ans;
    }
}