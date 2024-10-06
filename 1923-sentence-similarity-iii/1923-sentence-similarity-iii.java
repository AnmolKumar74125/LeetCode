class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        int len1 = sentence1.length(), len2 = sentence2.length();
        int a = 0, b = Math.min(len1 , len2) - 1;
        String shortSen = sentence2, longSen = sentence1;
        if( len1 < len2)
        {
            shortSen = sentence1;
            longSen = sentence2;
        }
        shortSen = " "+shortSen+" ";
        longSen = " "+longSen+" ";
        len1 = shortSen.length();
        len2 = longSen.length();
        int i = 0, j1 = len1-1, j2 = len2-1;
        int k = 0;
        while(i < len1)
        {
            if(shortSen.charAt(i) != longSen.charAt(i))
            {
                break;
            }
            if(shortSen.charAt(i) == ' ')
            {
                /*
                if(!(shortSen.substring(k,i+1).equals(longSen.substring(k,i+1))))
                {
                    break;
                }
                */
                k = i;
                a = i;
            }
            i++;
        }
        int k1 = len1, k2 = len2;
        while(j1>=0 && j2>=0)
        {
            if(shortSen.charAt(j1) != longSen.charAt(j2))
            {
                break;
            }
            if(shortSen.charAt(j1) == ' ')
            {
                /*
                if(!(shortSen.substring(j1, k1).equals(longSen.substring(j2, k2))))
                {
                    break;
                }
                */
                k1 = j1;
                k2 = j2;
                b = j1;
            }
            j1--;
            j2--;
        }
        System.out.println(a +".  "+b);
        if(b <= a)
        {
            return true;
        }
        return false;
    }
}