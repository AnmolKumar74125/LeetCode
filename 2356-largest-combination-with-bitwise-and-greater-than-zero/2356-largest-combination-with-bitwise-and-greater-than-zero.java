class Solution {
    public int largestCombination(int[] candidates) {
        
        int arr[] = new int [256];
        int max = 0;
        for(int i = 0; i < 256; i++)
        {
            int count = 0;
            for(int j = 0; j < candidates.length; j++)
            {
                if((candidates[j] & (1 << i)) > 0)
                {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}