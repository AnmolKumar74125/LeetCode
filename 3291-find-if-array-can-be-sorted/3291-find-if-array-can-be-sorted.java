class Solution {
    
    int[] BitsSetTable256 = new int[256];
    public void initialize()
    {
        BitsSetTable256[0] = 0;
        for (int i = 0; i < 256; i++) 
        {
            BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
        }
    }
    public boolean canSortArray(int[] nums) {
        initialize();
        int n=nums.length;
        boolean f1=true;
        boolean f2=true;
        for(int i=0;i<n;i++)
        {
            //int temp=nums[i],pos=i;
            for(int j=0;j<n-i-1;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    if(countSetBits(nums[j])!=countSetBits(nums[j+1]))
                    {
                        //System.out.println();
                        return false;
                    }
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            //System.out.println(i+" "+nums[i]+" " +countSetBits(nums[i])+"   "+pos+" "+nums[pos]+" "+countSetBits(nums[pos]));
            
        }
          //      System.out.println();
        return true;
    }
     public int countSetBits(int n)
    {
        return (BitsSetTable256[n & 0xff]
                + BitsSetTable256[(n >> 8) & 0xff]
                + BitsSetTable256[(n >> 16) & 0xff]
                + BitsSetTable256[n >> 24]);
    }
}