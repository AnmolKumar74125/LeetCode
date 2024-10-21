class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<Integer>());        
        generate(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    public void generate(int nums[], int index, List<Integer> temp, Set<List<Integer>> ans)
    {
        if(index > nums.length)
        {
            return;
        }
        //Collections.sort(temp);
        ans.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++)
        {
            temp.add(nums[i]);
            generate(nums, i + 1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}