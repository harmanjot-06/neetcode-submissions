class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] helper = new int[m][n];
        for(int j=n-1; j>=0; j--){
            helper[m-1][j] = 1;
        }
        for(int i=m-1; i>=0; i--){
            helper[i][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                helper[i][j] = helper[i+1][j] + helper[i][j+1];
            }
        }
        return helper[0][0];

    }
}
