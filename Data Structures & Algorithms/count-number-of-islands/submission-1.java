class Solution {
    Set<Pair<Integer, Integer>> visited = new HashSet<>();

    public int numIslands(char[][] grid) {
        int res = 0;

        for (int r  = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited.contains(new Pair<>(r, c))) {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
            visited.contains(new Pair<>(r, c)) ||
            grid[r][c] != '1') {
            return;
        }
        visited.add(new Pair<>(r, c));
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
