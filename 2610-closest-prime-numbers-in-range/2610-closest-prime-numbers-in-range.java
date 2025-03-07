class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int a = -1, b = -1, min = Integer.MAX_VALUE;

        if(right < 3)
        {
            return ans;
        }
        if(left <= 2 && right >= 3)
        {
            ans[0] = 2;
            ans[1] = 3;
            return ans;
        }
        int i = left, x = 1;
        int prev = -1, curr = -1;
        while(i <= right)
        {
            if(prev == -1)
            {
                if(isPrime(i))
                {
                    x = 2;
                    prev = i;
                    ans[0] = i;
                    if((i + 2) <= right && isPrime(i + 2))
                    {
                        ans[1] = i + 2;
                        return ans;
                    }
                }
            }
            else
            {
                //System.out.println("X " + " i = "+ i +" prev = "+ prev + " min = "+min);
                if(isPrime(i))
                {
                    if((i - prev) < min)
                    {
                        ans[0] = prev;
                        ans[1] = i;
                        min = i - prev;
                        prev = i;
                    }
                    else
                    {
                        prev = i;
                    }
                }
            }
            //System.out.println(Arrays.toString(ans));
            //System.out.println(i);
            i = i + x;
        }

        if(ans[1] == -1 || ans[0] == -1)
        {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public boolean isPrime(int n)
    {
        if(n == 2 || n == 3)
        {
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0)
        {
            return false;
        }
        for(int i = 5; i <= Math.sqrt(n); i+=6)
        {
            if(n % i == 0 || n % (i + 2) == 0)
            {
                return false;
            }
        }
        //System.out.println(n + "  is prime");
        return true;
    }

}