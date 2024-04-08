import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(String pos, String col){
        super(pos, col, "Pawn");
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();
        int direction;
        if(this.getColor().equals("white")){
             direction = -1;
        } else {
             direction = 1;
        }

        if (board.getPiece(row + direction, col) == null) {
            legalMoves.add(board.toAlgebraicNotation(row + direction, col));
            if ((this.getColor().equals("white") && row == 6) || (this.getColor().equals("black") && row == 1)) {
                if (board.getPiece(row + 2 * direction, col) == null) {
                    legalMoves.add(board.toAlgebraicNotation(row + 2 * direction, col));
                }
            }
        }

        if (col < 7 && board.getPiece(row + direction, col + 1) != null &&
                !board.getPiece(row + direction, col + 1).getColor().equals(this.getColor())) {
            legalMoves.add(board.toAlgebraicNotation(row + direction, col + 1));
        }

        if (col > 0 && board.getPiece(row + direction, col - 1) != null &&
                !board.getPiece(row + direction, col - 1).getColor().equals(this.getColor())) {
            legalMoves.add(board.toAlgebraicNotation(row + direction, col - 1));
        }

        return legalMoves;
    }



}



