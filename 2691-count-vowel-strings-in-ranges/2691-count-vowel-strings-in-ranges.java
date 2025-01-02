class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int n = queries.length;
        int ans[]=new int[n];
        int m = words.length;
        int arr[] = new int[m];
        int l = 0;
        for(int i = 0; i < m; i++)
        {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1)))
            {
                l++;
            }
            arr[i] = l;
        }
       // System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++)
        {
            ans[i] = arr[queries[i][1]] - (((queries[i][0] - 1) >= 0)?arr[queries[i][0] - 1] : 0);
        }
        return ans;
    }
    public boolean isVowel(char ch)
    {
        ch = Character.toUpperCase(ch);
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        {
            return true;
        }
        return false;
    }
}