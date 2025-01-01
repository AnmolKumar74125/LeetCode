class Solution {
    public int maxScore(String s) {
        
        int max = 0;
        int curr = 0;
        int n = s.length();
        int l = 0, r = 0;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            char ch2 = s.charAt(n-i-1);
            arr1[i] = l;
            arr2[n-i-1] = r;
            if(ch == '0')
            {
                arr1[i] = ++l;
            }
            if(ch2 == '1')
            {
                arr2[n-i-1] = ++r;
            }
        }
        max = Math.max(arr1[0]+arr2[1], arr1[n-2]+arr2[n-1]);
        for(int i = 1; i < n-1; i++)
        {
            //System.out.println(arr1[i] +"  "+arr2[i]+"  "+max);
            max = Math.max(max, arr1[i]+arr2[i]);
        }
        return max;
    }
}