class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int len1=s1.length();
        int len2=s2.length();

        if(len1!=len2)
        {
            return false;
        }
        int count=0;
        char a[]=new char[2];
        char b[]=new char[2];
        int k=0;
        for(int i=0;i<len1;i++)
        {
           char ch1=s1.charAt(i);
           char ch2=s2.charAt(i);
           if(ch1!=ch2)
           {
               if(k==2)
               {
                   return false;
               }
               a[k]=ch1;
               b[k]=ch2;
               k++;
           }
        }
        if(a.length==b.length&&(a.length==2||a.length==0))
        {
            int f=1;
            if(a.length==2 && a[0]==b[1] && a[1]==b[0])
            {
                f=0;
                return true;
            }
            if(f==0)
                return true;
        }
        return false;
    }
}