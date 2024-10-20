class Solution {
    public List<String> stringSequence(String target) {
        char ch[]= target.toCharArray();
        List<String> ans = new ArrayList<String>();
        String w = "";
        for(int i = 0; i < ch.length; i++)
        {
            String x = "";
            for(int j = 97; j <= ch[i]; j++)
            {
                x = w+((char)j);
                ans.add(x);
            }
            w = x;
        }
        return ans;
    }
}