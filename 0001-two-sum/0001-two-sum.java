class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
        int ans[] = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            if(hm.containsKey(target - nums[i]))
            {
                ans[0] = i;
                ans[1] = hm.get(target - nums[i]);
            }
            hm.put(nums[i], i);
        }
        return ans;
    }
}