class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) 
        {
            int val = nums.get(i);
            char ch[] = Integer.toBinaryString(val).toCharArray();
            int j;
            for (j = ch.length - 1; j > 0; j--) {
                if (ch[j] == '1' && ch[j - 1] == '0') {
                    break;
                }
            }
            ch[j] = '0';
            ans[i] = Integer.parseInt(new String(ch), 2);
            if ((ans[i] | ans[i] + 1) != val) {
                ans[i] = -1;
            }

        }
        return ans;
    }

}