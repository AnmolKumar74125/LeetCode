class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();
        int indexes[] = new int [n];
        int result[] = {0, Integer.MAX_VALUE};

        while(true)
        {
            int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
            int minRow = -1;
            for(int i = 0; i < n; i++)
            {
                int val = nums.get(i).get(indexes[i]);
                if(min > val)
                {
                    min = val;
                    minRow = i;
                }
                max = Math.max(val , max);
            }
            if((max - min) < (result[1]-result[0]))
            {
                result[0] = min;
                result[1] = max;
            }
            if( ++indexes[minRow] >= nums.get(minRow).size())
            {
                break;
            }
        }
        return result;
    }
}