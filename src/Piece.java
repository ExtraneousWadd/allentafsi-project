import java.util.ArrayList;

public class Piece {
    protected String position;
    protected String color;
    protected String type;
    protected boolean alive;

    public Piece(String position, String color, String type) {
        this.position = position;
        this.color = color;
        this.type = type;
        this.alive = true;
    }

    @Override
    public String toString() {
        return type + "{" +
                "position='" + position + '\'' +
                ", color='" + color + '\'' +
                ", alive=" + alive +
                '}';
    }

    public String getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getRow() {
        return position.charAt(1) - '1'; // Convert the numeric part of the position to row index
    }

    public int getColumn() {
        return position.charAt(0) - 'A'; // Convert the letter part of the position to column index
    }

    public ArrayList<String> getLegalMoves(Board board, int row, int col) {
        ArrayList<String> legalMoves = new ArrayList<>();
        return legalMoves;
    }


}