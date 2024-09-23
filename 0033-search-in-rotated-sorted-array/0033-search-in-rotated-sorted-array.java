class Solution {
    public int search(int[] nums, int target) {
        int peak=findPeak(nums);
        int n=nums.length;
        int ans=-1;
        if(target>=nums[0] && target<=nums[peak])
        {
            ans=findVal(nums,0,peak,target);
        }
        else
        {
            ans=findVal(nums,peak+1,n-1,target);
        }
        return ans;
    }
    public int findPeak(int nums[])
    {
        int l=0,h=nums.length-1,peak=0;
        if(h==0)
        {
            return 0;
        }
        if(nums[l]<=nums[h])
        {
            return h;
        }
        if(nums[l]>nums[l+1])
        {
            return l;
        }
        if(nums[h]<nums[h-1])
        {
            return h-1;
        }
        l=l+1;
        h=h-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if(nums[mid]<nums[h])
            {
                h=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        return 0;
    }
    public int findVal(int arr[],int l,int h,int x)
    {
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr[mid]==x)
            {
                return mid;
            }
            else if(arr[mid]>x)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return -1;
    }
}