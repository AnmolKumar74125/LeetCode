class Solution {
    public long dividePlayers(int[] skill) {

        long ans = 0 , sum = 0;
        Arrays.sort(skill);
        int n = skill.length;
        sum = skill[0] + skill[n-1];
        ans = skill[0] * skill[n-1];
        for(int i = 1; i <= (n-1)/2; i++)
        {
            if(sum != skill[i] + skill[n-i-1])
            {
                return -1;
            }
            ans = ans + (skill[i] * skill[n-i-1]);
        }   
        return ans;
    }
}