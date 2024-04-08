import java.util.ArrayList;

public class Board {
    private Piece[][] board;

    private String turn;
    public Board() {
        board = new Piece[8][8];

        board[0][0] = new Rook("A8", "black");
        board[0][1] = new Knight("B8", "black");
        board[0][2] = new Bishop("C8", "black");
        board[0][3] = new Queen("D8", "black");
        board[0][4] = new King("E8", "black");
        board[0][5] = new Bishop("F8", "black");
        board[0][6] = new Knight("G8", "black");
        board[0][7] = new Rook("H8", "black");
        board[1][0] = new Pawn("A7", "black");
        board[1][1] = new Pawn("B7", "black");
        board[1][2] = new Pawn("C7", "black");
        board[1][3] = new Pawn("D7", "black");
        board[1][4] = new Pawn("E7", "black");
        board[1][5] = new Pawn("F7", "black");
        board[1][6] = new Pawn("G7", "black");
        board[1][7] = new Pawn("H7", "black");

        board[7][0] = new Rook("A1", "white");
        board[7][1] = new Knight("B1", "white");
        board[7][2] = new Bishop("C1", "white");
        board[7][3] = new Queen("D1", "white");
        board[7][4] = new King("E1", "white");
        board[7][5] = new Bishop("F1", "white");
        board[7][6] = new Knight("G1", "white");
        board[7][7] = new Rook("H1", "white");
        board[6][0] = new Pawn("A2", "white");
        board[6][1] = new Pawn("B2", "white");
        board[6][2] = new Pawn("C2", "white");
        board[6][3] = new Pawn("D2", "white");
        board[6][4] = new Pawn("E2", "white");
        board[6][5] = new Pawn("F2", "white");
        board[6][6] = new Pawn("G2", "white");
        board[6][7] = new Pawn("H2", "white");
        turn = "white";

    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public static String toAlgebraicNotation(int row, int col) {
        char line = (char) ('a' + col);
        int rank = 8 - row;
        return "" + line + rank;
    }
    public static int[] fromAlgebraicNotation(String notation) {
        if (notation == null || notation.length() != 2) {
            throw new IllegalArgumentException("Invalid algebraic notation: " + notation);
        }
        int col = notation.charAt(0) - 'a';
        int row = 8 - Character.getNumericValue(notation.charAt(1));
        return new int[]{row, col};
    }
    public String getPieceType(Piece piece){
        if(piece instanceof Pawn){
            return "pawn";
        }
        if(piece instanceof Rook){
            return "rook";
        }
        if(piece instanceof Bishop){
            return "bishop";
        }
        if(piece instanceof King){
            return "king";
        }
        if(piece instanceof Queen){
            return "queen";
        }
        if(piece instanceof Knight){
            return "knight";
        }
        return "";
    }

    public boolean move(String start, String end) {
        int[] startCoords = fromAlgebraicNotation(start);
        int[] endCoords = fromAlgebraicNotation(end);
        int startRow = startCoords[0];
        int startCol = startCoords[1];
        int endRow = endCoords[0];
        int endCol = endCoords[1];

        if (board[startRow][startCol] == null || !board[startRow][startCol].getColor().equals(turn)){
            Game.showInvalidMoveMessage();
            return false;
        }

        Piece piece = board[startRow][startCol];
        ArrayList<String> legalMoves = piece.getLegalMoves(this, startRow, startCol);
        System.out.println(legalMoves);

        String endAlgebraic = toAlgebraicNotation(endRow, endCol);

        if (!legalMoves.contains(endAlgebraic)) {
            Game.showInvalidMoveMessage();
            return false;
        }
        board[endRow][endCol] = piece;
        board[startRow][startCol] = null;
        if(turn.equals("white")){
            turn = "black";
        } else {
            turn = "white";
        }
        return true;
    }



}