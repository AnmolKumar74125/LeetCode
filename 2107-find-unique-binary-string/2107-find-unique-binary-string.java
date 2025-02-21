class Solution {
    public String findDifferentBinaryString(String[] nums) {

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++ )
        {
            char ch = nums[i].charAt(i);
            if(ch == '0')
            {
                ans.append("1");
            }
            else
            {
                ans.append("0");
            }
        }
        return ans.toString();  
    }
}