class Solution {
    public int splitNum(int num) {
        
        int n = (int)Math.log10(num) + 1;
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(arr);
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < n; i+=2)
        {
            sum1 = sum1*10 + arr[i];
        }
        for(int i = 1; i < n; i+=2)
        {
            sum2 = sum2 * 10 + arr[i];
        }
        return sum1 + sum2;
    }
}