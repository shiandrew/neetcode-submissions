class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for (int r = 0; r < heights.length; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, heights[0].length - 1);
        }
        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, heights.length - 1, c);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific.contains(Arrays.asList(r, c)) &&
                    atlantic.contains(Arrays.asList(r, c))) {
                        res.add(Arrays.asList(r, c));
                    }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, Set<List<Integer>> ocean, int r, int c) {
        if (ocean.contains(Arrays.asList(r, c))) {
            return;
        }
        ocean.add(Arrays.asList(r, c));

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (newR >= 0 && newR < heights.length &&
                newC >= 0 && newC < heights[0].length &&
                heights[newR][newC] >= heights[r][c]) {
                dfs(heights, ocean, newR, newC);
            }
        }
    }
}
