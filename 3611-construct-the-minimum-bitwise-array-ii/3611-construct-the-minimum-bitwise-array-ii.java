class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int ans[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            /*
            int val = (int)Math.pow(2, count(nums.get(i))-1);
            if((val | (val - 1)) == nums.get(i))
            {
                ans[i] = val - 1;
            }
            else if((val | (val + 1)) == nums.get(i))
            {
                ans[i] = val;
            }
            else
            {
                ans[i] = -1;
            }
            System.out.println(val);
            */

            int val = nums.get(i);
            int c = count(nums.get(i));
            int v = (int) Math.pow(2, c) - 1;
 /*           if( v == val)
            {
                int x = (int) Math.pow(2, c - 1);
                if( (x | x-1) == val)
                {
                    ans[i] = x-1;
                }
                else
                {
                    ans[i] = -1;
                }
                continue;
            }
  //          System.out.println(Integer.toBinaryString(val));
            if((val & 1 ) == 0)
            {
                ans[i] = -1;
            }
            else
   */         {
                //ans[i] = ((val >> 1) << 1) ;
                char ch[] = Integer.toBinaryString(val).toCharArray();
                int j;
                for(j = ch.length-1; j > 0; j--)
                {
                    if(ch[j] == '1' && ch[j-1] =='0')
                    {
                      //  ch[j] = '0';
                        break;
                    }
                }
                ch[j] = '0';
                ans[i] = Integer.parseInt(new String(ch),2);
                if((ans[i] | ans[i]+1) != val)
                {
                    ans[i] = -1;
                }
            }
 //           System.out.println("ans[i] = "+ Integer.toBinaryString(ans[i]));
        }
        return ans;
    }

    int count(int n)
    {
        int c = 0;
        while(n > 0 && (n & 1) != 0)
        {
            c++;
            n = n >> 1;
        }
        return c;
    }
}