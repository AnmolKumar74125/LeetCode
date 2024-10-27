class Solution {
    public int countSquares(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        int mat[][]=new int[m][n];
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]!=0)
                {
                 //   System.out.println(i+" "+j+" "+matrix[i][j-1]+" "+matrix[i-1][j]+" "+matrix[i-1][j-1]+" "+Math.min(matrix[i][j-1],Math.min(matrix[i-1][j-1],mat[i-1][j]))+" "+Math.min(matrix[i-1][j-1],matrix[i-1][j]));
                    matrix[i][j]=Math.min(matrix[i][j-1],Math.min(matrix[i-1][j-1],matrix[i-1][j]))+1;
                }
            }
        }
        int sum=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                    sum=sum+matrix[i][j];
                
            }
        }
       /* for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                    System.out.print(matrix[i][j]+" ");
                
            }
            System.out.println();
        }*/
        return sum;
    }
}