class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Set<Integer> hs =new HashSet<Integer>();
        int len1 = arr1.length;
        for(int i = 0; i < len1; i++)
        {
            int countDigits =(int) Math.log10(arr1[i]);
            for(int j=0;j<=countDigits;j++)
            {
                hs.add(arr1[i]/(int)Math.pow(10,j));
            }
        }
        //System.out.println(hs);
        Arrays.sort(arr2);
        int len2 = arr2.length;
        int max = 0;
        for(int i = 0; i < len2; i++)
        {
            int countDigits = (int) Math.log10(arr2[i]);
            for(int j=0; j<=countDigits-max; j++)
            {
                int val = arr2[i]/(int)Math.pow(10,j);
                if(hs.contains(val))    
                {
                   // max = Math.max(max,countDigits-j);
                   max = Math.max(max,1+countDigits-j);
                }
                //System.out.println(val+". "+max);
            }
        }
        return max;
    }
}