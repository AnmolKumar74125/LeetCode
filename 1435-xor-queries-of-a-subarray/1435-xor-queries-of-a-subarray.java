class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int left[] = new int[n+1];
        int right[] = new int[n+1];

        for(int i = 0; i<n;i++)
        {
            left[i+1] = left[i] ^ arr[i];
            right[n-i-1] = right[n-i] ^ arr[n-i-1];
        }

        int ans[]=new int[queries.length];
        for(int i = 0; i < queries.length; i++)
        {
            ans[i] = left[queries[i][1]+1] ^ left[queries[i][0]];
        }
        return ans;
    }
}