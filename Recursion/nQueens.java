import java.util.ArrayList;
import java.util.List;

class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        if (n == 0)
            return result;

        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        solve(board, 0);
        return result;
    }

    private void solve(ArrayList<String> board, int row) {
        if (row == board.size()) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (String s : board) {
                solution.add(s.indexOf('Q') + 1);
            }
            result.add(solution);
            return;
        }

        for (int i = 0; i < board.size(); i++) {
            if (isValid(board, row, i)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(i, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1);

                newRow.setCharAt(i, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.size(); j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    if (j == col || Math.abs(row - i) == Math.abs(col - j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
