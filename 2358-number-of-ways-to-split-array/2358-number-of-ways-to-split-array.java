class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        long sumArr[] = new long[n];
        long total = 0;
        for(int i = 0; i < n; i++)
        {
            total = total + nums[i];
            sumArr[i] = total;
        }
        int ans = 0;
        for(int i = 0; i < n-1; i++)
        {
            if(sumArr[i] >= (total - sumArr[i]))
            {
                //break;
                //continue;
                ans++;
            }
            //ans++;
        }
        return ans;
    }
}