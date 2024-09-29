import java.util.*;
class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        
        Arrays.sort(maximumHeight);
        int curr = Integer.MAX_VALUE;
        long sum = 0;
        for(int i = maximumHeight.length - 1; i >= 0; i--)
        {
            curr = Math.min(curr-1, maximumHeight[i]);
            if( curr < 1)
            {
                return -1;
            }
            sum = sum + curr;
        }
        return sum;
    }
}