class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i=0;
        int n=nums.length;

        while(i<n)
        {
            if(nums[i]>0 && (nums[i]!=(i+1)) && (nums[i]<n) && (nums[nums[i]-1]!=nums[i]))
            {
                int temp=nums[i]-1;
                nums[i]=nums[nums[i]-1];
                nums[temp]=temp+1;
            }
            else
            {
                i++;
            }
        }
       
        for(i=0;i<n;i++)
        {
            if(nums[i]!=(i+1))
            {
                return (i+1);
            }
        }
        return n+1;
    }
}