package programmers.level2;

class P_가장큰정사각형찾기 {
    public static int solution(int[][] board) {
        int max = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    max = Math.max(max, check(board, i, j));
                }
            }
        }

        return max;
    }

    private static int check(int[][] board, int row, int col) {
        int nRow = row, nCol = col;
        int w = 0;
        int size = 0;

        while (nCol < board[nRow].length && board[nRow][nCol] == 1) {
            w++;
            nCol++;
        }
        nCol = col;
        nRow++;
        size += w;
        boolean isNotSquare = false;
        while (nRow < board.length && board[nRow][nCol] == 1) {
            for (int i = 0; i < w; i++) {
                if(board[nRow][nCol+i] != 1){
                    isNotSquare = true;
                    break;
                }
                size++;
            }
            if(isNotSquare) break;
            nRow++;
        }
        return isNotSquare? 0 : size;
    }

    public static void main(String[] args){
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));

    }
}
