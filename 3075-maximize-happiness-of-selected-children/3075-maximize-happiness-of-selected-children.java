class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int n=happiness.length-1;
        long ans=0;
        int x=0;
        Arrays.sort(happiness);
        for(int i=0;i<k;i++)
        {
            ans = ans+ ((happiness[n]-x)>=0?happiness[n]-x:0);
            n--;
            x++;
        }
        return ans;
    }
}