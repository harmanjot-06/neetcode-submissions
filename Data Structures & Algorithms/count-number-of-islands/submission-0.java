class Solution {

    boolean[][] visited;

    void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || i>=visited.length || j<0 || j>=visited[0].length)return;
        if(visited[i][j])return;
        if(grid[i][j]=='0')return;

        visited[i][j] = true;
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i, j+1);
    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                visited[i][j] = false;
            }
        }
        int count = 0;
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
}
