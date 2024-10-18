class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        generatePermute(nums,new ArrayList<Integer>(),ans,freq);
        return ans;
    }

    public void generatePermute(int[] nums, List<Integer> temp,List<List<Integer>> ans,boolean[] freq)
    {
        if(nums.length==temp.size())
        {
            ans.add(new ArrayList<>(temp));
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!freq[i])
            {
                temp.add(nums[i]);
                freq[i]=true;
                generatePermute(nums,temp,ans,freq);
                temp.remove(temp.size()-1);
                freq[i]=false;
            }
        }
    }
}