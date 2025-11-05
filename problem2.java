class Solution {
    int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean exists;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;

        m = board.length;
        n = board[0].length;
        exists = false;

        int[][] visited = new int[m][n];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = 1;
                    dfs(board, word, 1, visited, i, j);
                    visited[i][j] = 0;
                }
            }
        }

        return exists;
    }

    public void dfs(char[][] board, String word, int idx, int[][] visited, int i, int j) {
        if (idx == word.length() || exists) {
            exists = true;
            return;
        }
        for (int[] dir : DIRS) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI>=0 && newJ>=0 && newI<m && newJ<n && visited[newI][newJ] == 0 && word.charAt(idx) == board[newI][newJ]) {
                visited[newI][newJ] = 1;
                dfs(board, word, idx + 1, visited, newI, newJ);
                visited[newI][newJ] = 0;
            }
        }
    }
}
