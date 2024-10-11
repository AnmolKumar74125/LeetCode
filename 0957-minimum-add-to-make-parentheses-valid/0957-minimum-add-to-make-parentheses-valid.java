class Solution {
    public int minAddToMakeValid(String s) {

        int count = 0, count2 = 0, n = s.length();
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                count++;
            }
            else
            {
                if(count > 0)
                {
                    count--;
                }
                else
                {
                    count2++;
                }
            }
           // System.out.println(ch+".  "+count+".  "+count2);
        }
        return count + count2;   
    }
}