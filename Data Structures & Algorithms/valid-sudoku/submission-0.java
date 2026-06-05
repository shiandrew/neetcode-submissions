class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] sqr = new HashSet[board.length];
        Set<Integer>[] row = new HashSet[board.length];
        Set<Integer>[] col = new HashSet[board[0].length];
        for (int i = 0; i < 9; i++) {
            sqr[i] = new HashSet<>();
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int c = Character.getNumericValue(board[i][j]);
                    if(sqr[i/3 * 3 + j/3].contains(c) ||
                    row[i].contains(c) || col[j].contains(c))
                        return false;
                    sqr[i/3 * 3 + j/3].add(c);
                    row[i].add(c);
                    col[j].add(c);
                }
            }
        }
        return true;
    }
}
