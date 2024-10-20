class Solution {
    public int numberOfSubstrings(String s, int k) {
        
        char ch[] = s.toCharArray();
        
        int ans = 0;
        for(int i = 0; i < ch.length; i++)
        {
            int freq[] = new int[26];
            for(int j = i; j < ch.length; j++)
            {
                freq[ch[j]-97]++;
                if(freq[ch[j]-97] >= k)
                {
                    ans = ans + (ch.length - j);
                    //System.out.println(j);
                    //System.out.println(ans);
                    break;
                }
            }
            //System.out.println(Arrays.toString(freq));
            freq[ch[i]-97]--;
        }
        return ans;
    }
}