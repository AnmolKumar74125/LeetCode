class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int arr[] = new int[2];
        int i = 0, j = 0, n = blocks.length();
        int min = Integer.MAX_VALUE;
        while(i <= j && j < n)
        {
            char ch = blocks.charAt(j);
            if (ch == 'B') 
            {
                arr[0]++;
            } 
            else
            {
                arr[1]++;
            }
            //System.out.println(Arrays.toString(arr));
            while(i <= j && arr[0] + arr[1] >= k)
            {
                min = Math.min(min, arr[1]);
                if (blocks.charAt(i) == 'B') 
                {
                    arr[0]--;
                }
                else 
                {
                    arr[1]--;
                }
                i++;
            }
            j++;
        }
        return min;
    }
}