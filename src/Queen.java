import java.awt.image.*;
import java.util.ArrayList;
public class Queen extends Piece {
    public Queen(String pos, String col) {
        super(pos, col, "Queen");
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();
        Piece queen = board.getPiece(row, col);
        if (queen == null) return legalMoves;

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        for (int[] direction : directions) {
            int currentRow = row + direction[0];
            int currentCol = col + direction[1];
            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                Piece pieceAtCurrent = board.getPiece(currentRow, currentCol);
                if (pieceAtCurrent == null) {
                    legalMoves.add(board.toAlgebraicNotation(currentRow, currentCol));
                } else {
                    if (!pieceAtCurrent.getColor().equals(queen.getColor())) {
                        legalMoves.add(board.toAlgebraicNotation(currentRow, currentCol));
                    }
                    break;
                }
                currentRow += direction[0];
                currentCol += direction[1];
            }
        }
        return legalMoves;
    }



}
