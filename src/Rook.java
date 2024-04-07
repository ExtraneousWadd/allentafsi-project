import java.awt.image.*;
import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(String pos, String col) {
        super(pos, col, "Rook");
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();

        for (int c = col + 1; c < 8; c++) {
            Piece piece = board.getPiece(row, c);
            if (piece == null) {
                legalMoves.add(board.toAlgebraicNotation(row, c));
            } else {
                if (!piece.getColor().equals(this.getColor())) {
                    legalMoves.add(board.toAlgebraicNotation(row, c));
                }
                break;
            }
        }

        // Check left
        for(int c = col - 1; c >= 0; c--){
            Piece piece = board.getPiece(row, c);
            if (piece == null) {
                legalMoves.add(board.toAlgebraicNotation(row, c));
            } else {
                if (!piece.getColor().equals(this.getColor())) {
                    legalMoves.add(board.toAlgebraicNotation(row, c));
                }
                break;
            }
        }

        // Check up
        for (int r = row - 1; r >= 0; r--) {
            Piece piece = board.getPiece(r, col);
            if (piece == null) {
                legalMoves.add(board.toAlgebraicNotation(r, col));
            } else {
                if (!piece.getColor().equals(this.getColor())) {
                    legalMoves.add(board.toAlgebraicNotation(r, col));
                }
                break;
            }
        }


        for (int r = row + 1; r < 8; r++) {
            Piece piece = board.getPiece(r, col);
            if (piece == null) {
                legalMoves.add(board.toAlgebraicNotation(r, col));
            } else {
                if (!piece.getColor().equals(this.getColor())) {
                    legalMoves.add(board.toAlgebraicNotation(r, col));
                }
                break;
            }
        }

        return legalMoves;
    }

}


