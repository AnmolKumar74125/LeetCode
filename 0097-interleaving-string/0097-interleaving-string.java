class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1+len2 != s3.length())
        {
            return false;
        }
        String mat[][] = new String[len1+1][len2+2];
        mat[0][0] = "";
        for(int i = 1; i <= len1; i++)
        {
            Arrays.fill(mat[i],"");
            mat[i][0] = s1.substring(0,i);
        }    
        for(int i = 1; i <= len2; i++)
        {
            mat[0][i] = s2.substring(0,i);
        }

        for(int i = 1; i <= len1; i++)
        {
            for(int j = 1; j <= len2; j++)
            {
                String part = s3.substring(0, (i+j));
                if(part.equals(mat[i][0]+mat[0][j]) || part.equals(mat[0][j]+mat[i][0]) || 
                    part.equals(mat[i-1][j]+s1.charAt(i-1)) || part.equals(mat[i][j-1]+s2.charAt(j-1)))
                {
                    mat[i][j] = part;
                }
                else
                {
                    mat[i][j] = mat[i-1][j-1];
                }
            }
        }
        return mat[len1][len2].equals(s3);
    }
}