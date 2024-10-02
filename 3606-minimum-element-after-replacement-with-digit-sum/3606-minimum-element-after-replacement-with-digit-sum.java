class Solution {
    public int minElement(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            int p = nums[i];
            int sum = 0;
            while(p!=0)
            {
                sum = sum + (p % 10);
                p = p / 10;
            }
            min = Math.min(sum , min);
        }
        return min;
    }
}