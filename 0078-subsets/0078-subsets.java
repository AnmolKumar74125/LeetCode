class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
       // List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        ans.add(new ArrayList<>());
        
        generate(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    public void generate(int nums[], int index, List<Integer> temp, Set<List<Integer>> ans)
    {
        if(index > nums.length)
        {
            //ans.add(new ArrayList<>(temp));
            return;
        }
        
        ans.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++)
        {
            temp.add(nums[i]);
            generate(nums, i + 1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}