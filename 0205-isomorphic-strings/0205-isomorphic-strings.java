class Solution {
    public boolean isIsomorphic(String s, String t) {

        int l1=s.length();
        int l2=t.length();
        int arr1[]=new int[128];
        int arr2[]=new int[128];
        for(int i=0;i<l1;i++)
        {
            if(arr1[s.charAt(i)] != arr2[t.charAt(i)])
            {
                return false;
            }
            arr1[s.charAt(i)]=i+1;
            arr2[t.charAt(i)]=i+1;
            
        }
        return true;
    }
}