class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int findrow = -1;
        int rowstart = 0;
        int rowend = matrix.length - 1;

        while(rowstart<=rowend){
            int currrow = rowstart + (rowend-rowstart)/2;
            if(target >= matrix[currrow][0] && target <= matrix[currrow][matrix[0].length - 1]){
                findrow = currrow;
                break;
            }
            else if(target > matrix[currrow][matrix[0].length - 1]){
                rowstart = currrow + 1;
            }
            else{
                rowend = currrow - 1;
            }
        }
        if(findrow == -1){
            return false;
        }

        int l = 0;
        int r = matrix[0].length - 1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[findrow][mid]==target){
                return true;
            }
            else if(matrix[findrow][mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return false;
    }
}
