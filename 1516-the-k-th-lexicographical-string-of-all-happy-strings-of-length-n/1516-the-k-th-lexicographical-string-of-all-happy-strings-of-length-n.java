class Solution {
    public String getHappyString(int n, int k) {
        char arr[] = {'a', 'b', 'c'};
        String s = "a";
        List<String> temp = new ArrayList<String>();
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i-1) == 'a')
            {
                s += "b";
            }
            else
            {
                s += "a";
            }
        }
        generate(s, s.length()-1, temp, n, k);
        System.out.println(temp);
        return (k <= temp.size())?temp.get(k-1): "";
    }

    public void generate(String s, int ind, List<String> temp, int n, int k)
    {
        if( k < 0 || ind < 0)
        {
            return;
        }
        char ch = s.charAt(ind);
        if(ch == 'c')
        {
            if(ind == 0)
            {
                if(isHappy(s))
                {
                    temp.add(s);
                }
            }
            generate(s, ind-1, temp, n, k);
        }
        else
        {
            if(isHappy(s))
            {
                temp.add(s);
                k = k - 1;
            }
            ch = (char)(ch + 1);
            s = s.substring(0, ind) + ch;
            for(int i = s.length(); i < n; i++)
            {
                if(s.charAt(i-1) == 'a')
                {
                    s += "b";
                }
                else
                {
                    s += "a";
                }
            }
            ind = s.length()-1;
           // if(isHappy(s))
            {
                generate(s, ind, temp, n, k);    
            }
           // generate(s, ind-1, temp, n, k-1);
        }
    }

    public boolean isHappy(String s)
    {
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i-1) == s.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
}