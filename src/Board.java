public class Board {
    private Piece[][] board;
    public Board() {
        board = new Piece[8][8];

        board[0][0] = new Rook("A1", "white");
        board[0][1] = new Knight("B1", "white");
        board[0][2] = new Bishop("C1", "white");
        board[0][3] = new Queen("D1", "white");
        board[0][4] = new King("E1", "white");
        board[0][5] = new Bishop("F1", "white");
        board[0][6] = new Knight("G1", "white");
        board[0][7] = new Rook("H1", "white");
        board[1][0] = new Pawn("A2", "white");
        board[1][1] = new Pawn("B2", "white");
        board[1][2] = new Pawn("C2", "white");
        board[1][3] = new Pawn("D2", "white");
        board[1][4] = new Pawn("E2", "white");
        board[1][5] = new Pawn("F2", "white");
        board[1][6] = new Pawn("G2", "white");
        board[1][7] = new Pawn("H2", "white");

        board[7][0] = new Rook("A8", "black");
        board[7][1] = new Knight("B8", "black");
        board[7][2] = new Bishop("C8", "black");
        board[7][3] = new Queen("D8", "black");
        board[7][4] = new King("E8", "black");
        board[7][5] = new Bishop("F8", "black");
        board[7][6] = new Knight("G8", "black");
        board[7][7] = new Rook("H8", "black");
        board[6][0] = new Pawn("A7", "black");
        board[6][1] = new Pawn("B7", "black");
        board[6][2] = new Pawn("C7", "black");
        board[6][3] = new Pawn("D7", "black");
        board[6][4] = new Pawn("E7", "black");
        board[6][5] = new Pawn("F7", "black");
        board[6][6] = new Pawn("G7", "black");
        board[6][7] = new Pawn("H7", "black");

    }

        public Piece getPiece(int row, int col) {
            return board[row][col];
        }

        public void printBoard () {
            for (Piece[] row : board) {
                for (Piece space : row) {
                    System.out.print(space + " ");
                }
                System.out.println();
            }
        }
    }