import java.awt.image.*;
import java.util.ArrayList;
public class Knight extends Piece {
    public Knight(String pos, String col) {
        super(pos, col, "Knight");
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();
        Piece knight = board.getPiece(row, col);
        if (knight == null) return legalMoves;

        int[][] moves = {
                {-2, -1}, {-2, 1}, // Upwards L-shapes
                {-1, -2}, {-1, 2}, // Left and right L-shapes
                {1, -2}, {1, 2},   // Left and right L-shapes
                {2, -1}, {2, 1}    // Downwards L-shapes
        };

        for (int[] move : moves) {
            int targetRow = row + move[0];
            int targetCol = col + move[1];

            if (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol < 8) {
                Piece pieceAtTarget = board.getPiece(targetRow, targetCol);
                if (pieceAtTarget == null || !pieceAtTarget.getColor().equals(knight.getColor())) {
                    legalMoves.add(board.toAlgebraicNotation(targetRow, targetCol));
                }
            }
        }
        return legalMoves;
    }

}

