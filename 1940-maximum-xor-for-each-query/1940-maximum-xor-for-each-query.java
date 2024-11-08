class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int val = (1 << maximumBit)-1;
        int currVal = 0;
        int ans[] = new int[nums.length];
        for(int i = 0; i< nums.length; i++)
        {
            currVal = currVal ^ nums[i];
            ans[nums.length-i-1] = currVal ^ val;
        }
        return ans;
    }
}