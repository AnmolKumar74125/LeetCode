class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long ans = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < nums.length; i++)
        {
            pq.add(nums[i]);
        }
        while(k > 0)
        {
            int x = pq.poll();
            ans = ans + x;
            pq.add((int)Math.ceil(x/3.0));
            k--;
        }
        return ans;
    }
}