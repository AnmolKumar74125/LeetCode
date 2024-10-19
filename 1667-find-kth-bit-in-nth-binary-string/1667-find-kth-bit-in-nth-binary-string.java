class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        s = cal( s, n);
        return s.charAt(k-1);
    }
    public String cal(String s, int n)
    {
        if(n <= 1)
        {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            sb.append((s.charAt(i) == '0') ? '1' : '0');
        }
        String w =sb.reverse().toString();
        s = s + "1" + w;
        s = cal(s, n-1);
        return s;
    }
}