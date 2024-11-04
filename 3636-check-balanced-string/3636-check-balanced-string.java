class Solution {
    public boolean isBalanced(String num) {

        int even = 0, odd = 0 , f = 0;
        for(int i =0; i<num.length();i++)
            {
                if(i%2==0)
                {
                    even = even + (num.charAt(i) - 48);
                }
                else
                {
                    odd = odd + (num.charAt(i) - 48);
                }
            }
        if( even == odd)
        {
            return true;
        }
        return false;
    }
}