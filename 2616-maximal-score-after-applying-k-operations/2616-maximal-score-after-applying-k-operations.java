class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++)
        {
            pq.offer(nums[i]);
        }
        //System.out.println(pq);
        while(k > 0)
        {
            int x = pq.poll();
            ans = ans + x;
            pq.offer((int)Math.ceil(x/3.0));
            k--;
        //    System.out.println(ans+".  "+x);
        //    System.out.println(pq);
        }
        return ans;
    }
}