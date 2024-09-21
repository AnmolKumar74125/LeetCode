class Solution {
    public int findTheLongestSubstring(String s) {
        
        int n = s.length();
        int arr[] = new int[n + 1];
        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                arr[i+1] = arr[i] ^ (int)ch;
            }
            else
            {
                arr[i+1] = arr[i] ^ 0;
            }
        }
        Map<Integer,Integer> first = new HashMap<Integer,Integer>();
        Map<Integer,Integer> last = new HashMap<Integer, Integer>();
        for(int i=0; i<=n; i++)
        {
            System.out.print(arr[i]+" ");
            if(first.containsKey(arr[i]))
            {
                last.put(arr[i],i);
            }
            else
            {
                first.put(arr[i],i);
                last.put(arr[i],i);
            }
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : first.entrySet())
        {
            max = Math.max((last.get(entry.getKey()) - entry.getValue()) , max);
        }
        return max;
    }
}