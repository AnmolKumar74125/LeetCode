class Solution {
    public int maxArea(int[] height) {
        
        int maxArea=0;
        int i=0,j=height.length-1;
        while(i<j)
        {
            maxArea=Math.max(maxArea,(j-i)*(Math.min(height[i],height[j])));
            if(height[i]>=height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return maxArea;
    }
}