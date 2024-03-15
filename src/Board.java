public class Board {
    private Piece[][] board;
    public Board(){
        board = new Piece[8][8];
        int colour = 0;
        for(int r = 0; r < 8; r++) {
            if(colour == 0){
                colour = 1;
            } else {
                colour = 0;
            }
            for(int c = 0; c  < 8; c++) {
                if(colour == 0){
                    board[r][c] = "🟫";
                    colour = 1;
                } else {
                    board[r][c] = "⬜";
                    colour = 0;
                }
            }
        }
        board[0][0] = "♙";
        board[0][7] = "♟";

    }

    public void printBoard() {
        for(Piece[] row : board) {
            for(Piece space : row) {
                System.out.print(space);
            }
            System.out.println();
        }
    }
}
