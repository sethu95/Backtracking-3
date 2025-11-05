class Solution {
    List<List<String>> result;
    int n;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }
        result = new ArrayList<>();
        this.n = n;

        backtrack(board, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);

        return result;
    }

    private void backtrack(char[][] board, Set<Integer> colSet, Set<Integer> negativeDiagSet, Set<Integer> positiveDiagSet, int row) {

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int k=0; k<n; k++) {
                list.add(String.valueOf(board[k]));
            }
            result.add(list);
            return;
        }
        
        for (int col = 0; col<n; col++) {
            int posDiag = row+col;
            int negDiag = row-col;

            if (colSet.contains(col) || positiveDiagSet.contains(posDiag) || negativeDiagSet.contains(negDiag)) {
                continue;
            }

            colSet.add(col);
            positiveDiagSet.add(posDiag);
            negativeDiagSet.add(negDiag);
            board[row][col] = 'Q';

            backtrack(board, colSet, negativeDiagSet, positiveDiagSet, row+1);

            colSet.remove(col);
            positiveDiagSet.remove(posDiag);
            negativeDiagSet.remove(negDiag);
            board[row][col] = '.';

        }
    }
}
