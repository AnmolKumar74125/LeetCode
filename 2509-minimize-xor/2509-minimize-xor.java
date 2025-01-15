class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int count = 0;
        int arr[] = new int[32];
        int total = 0;
        for(int i = 0; i < 32; i++)
        {
            arr[31-i] = (num1 >> i) & 1;
            count = count + arr[31-i];
            total = total + ((num2 >> i) & 1);
        }
        System.out.println("total = "+ total);
        System.out.println("count = "+ count);
        System.out.println("arr = "+ Arrays.toString(arr));
        if(total == count)
        {
            return num1;
        }
        else if(total < count)
        {
            int x = count - total;
            for(int i = 0; i < 32 && x > 0; i++)
            {
                if(arr[31-i] == 1)
                {
                    arr[31-i] = 0;
                    x--;
                }
            }
        }
        else
        {
            int x = total - count;
            int arr2[] = new int[32];
            for(int i = 31; i >= 0; i--)
            {
                if(x > 0 && arr[i] == 0)
                {
                    arr[i] = 1;
                    x--;
                }
            }
            //arr = arr2;
        }
        System.out.println("arr = "+ Arrays.toString(arr));
        int ans = 0;
        for(int i = 0; i < 32; i++)
        {
            ans = (ans << 1) + arr[i];
        }
        return ans;
    }
}