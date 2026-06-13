class Solution {
    Set<List<Integer>> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length ||
        col >= board[0].length ||
        board[row][col] != word.charAt(i) ||
        visited.contains(Arrays.asList(row, col))) {
            return false;
        }

        visited.add(Arrays.asList(row, col));
        boolean res = dfs(board, word, row - 1, col, i + 1)||
                      dfs(board, word, row + 1, col, i + 1)||
                      dfs(board, word, row, col - 1, i + 1)||
                      dfs(board, word, row, col + 1, i + 1);

        visited.remove(Arrays.asList(row, col));

        return res;
    }
}
