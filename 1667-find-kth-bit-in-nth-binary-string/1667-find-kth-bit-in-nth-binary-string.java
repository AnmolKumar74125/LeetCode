class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        if( n == 2)
        {
            s = "011";
        }
        s = cal( s, n);
        System.out.println(s);
        return s.charAt(k-1);
    }
    public String cal(String s, int n)
    {
        if(n <= 1)
        {
            return s;
        }
        /*
        String w = Integer.toBinaryString(((~Integer.parseInt(s,2))& ((1 << s.length()) - 1)));
        w = new StringBuilder(w).reverse().toString();
        */
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            sb.append((s.charAt(i) == '0') ? '1' : '0');
        }
        String w =sb.reverse().toString();
        //System.out.println(s+"  "+w);
        s = s + "1" + w;
        s = cal(s, n-1);
        return s;
    }
}