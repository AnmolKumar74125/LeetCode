class Solution {
    public int maxGoodNumber(int[] nums) {
        int n = nums.length;
        String arr[] = new String[n];
        for(int i = 0;i < n; i++)
        {
            arr[i] = Integer.toBinaryString(nums[i]);
        }
        int ans = 0;
        for(int i = 0; i < 3; i++)
        {
            String ansStr = arr[i]+arr[(i+1)%n]+arr[(i+2)%n];
            ans = Math.max(Integer.parseInt(ansStr, 2) , ans);
            ansStr = arr[i]+arr[(i+2)%n]+arr[(i+1)%n];
            ans = Math.max(Integer.parseInt(ansStr, 2) , ans);
        }
        return ans;
    }
}