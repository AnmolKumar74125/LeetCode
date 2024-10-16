class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Create an array to store the maximum values from the right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        
        // Fill the maxRight array
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        // Find the maximum width ramp
        while (j < n) {
            //System.out.println(n+". "+j);
            
            while (i < j && nums[i] > maxRight[j]) {
                i++;
                if(ramp > (n-i)+1)
                {
                    break;
                }
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }

        return ramp;
    }
}

/*
nums = [6,0,8,2,1,5]
max =  [8,8,8,5,5,5]
*/