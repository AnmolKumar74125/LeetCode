class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int n = timePoints.size();
        int arr[] = new int[n];

        for(int i = 0; i < timePoints.size(); i++)
        {
            arr[i] = (Integer.parseInt(timePoints.get(i).substring(0,2)) * 60) + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n;i++)
        {
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        min = Math.min(min, (1440 + arr[0]) - arr[n-1]);
        return min;
    }
}