class Solution {
    public int maximumSwap(int num) {
        
        int n = (int)Math.log10(num) + 1;
        int arr[] = new int[n];
        int maxArr[] = new int[n];
        int p = num, x = n - 1;
        maxArr[n-1] = n-1;
        while(p > 0)
        {
            arr[x--] = p % 10;
            p = p / 10;
        }
        int max = 0;
        for(int i = n-2; i >= 0; i--)
        {
            if(max < arr[i+1])
            {
                maxArr[i] = i+1;
                max = arr[i+1];
                continue;
            }
            maxArr[i] = maxArr[i+1];
        }
        for(int i = 0; i < n-1; i++)
        {
            if(arr[i] < arr[maxArr[i]])
            {
                int temp = arr[i];
                arr[i] = arr[maxArr[i]];
                arr[maxArr[i]] = temp;
                break;
            }
        }
        int ans = 0;
        for(int  i = 0; i < n; i++)
        {
            ans = ans * 10 +arr[i];
        }
        return ans;
    }
}