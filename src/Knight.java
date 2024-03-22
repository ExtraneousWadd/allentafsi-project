
public class Knight extends Piece {
    public Knight(String pos, String col) {
        super(pos, col);
    }
    public boolean isValidMove(String newPosition) {

        int currentRow = getRow(); // Get the current row of the king
        int currentColumn = getColumn(); // Get the current column of the king

        int newRow = newPosition.charAt(1) - '1'; // Convert the numeric part of the new position to row index
        int newColumn = newPosition.charAt(0) - 'A'; // Convert the letter part of the new position to column index

        // Check if the new position is adjacent to the current position
        return Math.abs(newRow - currentRow) <= 1 && Math.abs(newColumn - currentColumn) <= 1;
    }
}

