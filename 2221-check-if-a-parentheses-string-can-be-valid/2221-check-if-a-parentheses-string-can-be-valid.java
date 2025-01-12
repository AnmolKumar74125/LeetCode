class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int index = -1;
        int n = s.length();
        int open1 = 0, close1 = 0, flip1 = 0;
        int open2 = 0, close2 = 0, flip2 = 0;
        int arr[] = new int[n];
        if(n % 2 != 0)
        {
            return false;
        }
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(locked.charAt(i) == '0')
            {
                flip1++;
            }
            else
            {
                if(ch == '(')
                {
                    open1++;
                }
                else
                {
                    close1++;
                }
            }
            char ch2 = s.charAt(n-1-i);
            if(locked.charAt(n-1-i) == '0')
            {
                flip2++;
            }
            else
            {
                if(ch2 == '(')
                {
                    open2++;
                }
                else
                {
                    close2++;
                }
            }
            //System.out.println("open1 = "+ open1 +" close1 = "+ close1 + " flip1 = "+flip1);
            
            //System.out.println("open2 = "+ open2 +" close2 = "+ close2 + " flip2 = "+flip2);
            if(flip1 + open1 < close1 || flip2 + close2 < open2) 
            {
                return false;
            }
        }
        return true;
    }
}