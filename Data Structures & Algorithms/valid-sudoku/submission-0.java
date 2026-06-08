class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i ++) {
            Set<Character> s = new HashSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }
        // Check cols
        for (int i = 0; i < 9; i ++) {
            Set<Character> s = new HashSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] == '.') continue;
                if(s.contains(board[j][i])) return false;
                s.add(board[j][i]);
            }
        }
        // Check 3x3 box
        for(int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> s = new HashSet<>();
                for (int x = i; x < i + 3; x ++) {
                    for (int y = j; y < j + 3; y ++) {
                        if (board[x][y] == '.') continue;
                        if(s.contains(board[x][y])) return false;
                        s.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
}
