import java.awt.image.*;
import java.util.ArrayList;
 public class King extends Piece {
    public King(String pos, String col) {
        super(pos, col, "King");
    }

     public ArrayList<String> getLegalMoves(Board board, int row, int col) {
         ArrayList<String> legalMoves = new ArrayList<>();
         int[] rowDiffs = {-1, -1, -1, 0, 0, 1, 1, 1};
         int[] colDiffs = {-1, 0, 1, -1, 1, -1, 0, 1};

         for (int i = 0; i < rowDiffs.length; i++) {
             int newRow = row + rowDiffs[i];
             int newCol = col + colDiffs[i];


             if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                 Piece targetPiece = board.getPiece(newRow, newCol);
                 if (targetPiece == null || !targetPiece.getColor().equals(color)) {
                     legalMoves.add(board.toAlgebraicNotation(newRow, newCol));
                 }
             }
         }
         return legalMoves;
     }

}
