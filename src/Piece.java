
public class Piece {
    private String position;
    private String color;
    private boolean dead;
    public Piece(String pos, String col){
        position = pos;
        color = col;
        dead = false;

    }
    public String getPosition() {
        return position;
    }
    public String getColor() {
        return color;
    }
    public boolean isDead() {
        return this.dead;
    }
    public int getRow() {
        return position.charAt(1) - '1'; // Convert the numeric part of the position to row index
    }

    public int getColumn() {
        return position.charAt(0) - 'A'; // Convert the letter part of the position to column index
    }
}
