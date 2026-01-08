class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> ans =new HashSet<>();
        int i = 0, n = nums.length - 1;
        while(i < n - 1)
        {
            int k = i + 1;
            int t = n;
            while(k < t)
            {
                if(nums[i] + nums[k] + nums[t] == 0)
                {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[k]);
                    temp.add(nums[t]);
                    ans.add(temp);
                    k++;
                }
                else if(nums[i] + nums[k] + nums[t] > 0)
                {
                    t--;
                }
                else
                {
                    k++;
                }
            }
            i++;
        }
        return new ArrayList<>(ans);
    }
}