import java.awt.image.*;
import java.util.ArrayList;
public class Bishop extends Piece {
    public Bishop(String pos, String col) {
        super(pos, col, "Bishop");
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();
        Piece bishop = board.getPiece(row, col);
        if (bishop == null) return legalMoves;

        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int[] direction : directions) {
            int currentRow = row + direction[0];
            int currentCol = col + direction[1];
            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                Piece current = board.getPiece(currentRow, currentCol);
                if (current == null) {
                    legalMoves.add(board.toAlgebraicNotation(currentRow, currentCol));
                } else {
                    if (!current.getColor().equals(bishop.getColor())) {
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
