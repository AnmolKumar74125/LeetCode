class Solution {
    public String longestDiverseString(int a, int b, int c) {

        int arr[] = new int[3];
        int used[] = new int[3];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> y-x);
        String ans = "";
        char prev = ' ';
        pq.add(a*10+1);
        pq.add(b*10+2);
        pq.add(c*10+3);
        System.out.println(pq);
        while(a+b+c > (used[0]+used[1]+used[2]))
        {
            if(pq.isEmpty())
            {
                break;
            }
            int val1 = pq.poll();
            if(val1 < 10)
            {
                continue;
            }
            char curr = (char)('a' + (val1 % 10) - 1);
           // System.out.println("A = " + val1+".  "+curr);
            if(arr[curr - 97] < 2)
            {
                ans = ans + curr;
                arr[curr - 97]++;
                used[curr - 97]++;
                if((val1 / 10) -1 > 0)
                {
                    pq.add(val1 - 10);
                }
                if( prev != ' ' && prev != curr)
                {
                    arr[prev - 97] = 0;
                }
                prev = curr;
            }
            else
            {
                if(pq.isEmpty())
                {
                    break;
                }
                int val2 = pq.poll();
                if(val2 < 10)
                {
                    continue;
                }
                curr = (char)('a' + (val2 % 10) - 1);
               // System.out.println("B = " + val2+".  "+curr);
                ans = ans + curr;
                arr[curr - 97]++;
                used[curr - 97]++;
                if((val2 / 10) -1 > 0)
                {
                    pq.add(val2 - 10);
                }
                if((val1 / 10) -1 >= 0)
                {
                    pq.add(val1);
                }
                if( prev != ' ' && prev != curr)
                {
                    arr[prev - 97] = 0;
                }
                prev = curr;
            }
           // System.out.println(pq);
        }
        System.out.println(pq);
        return ans;
    }
}