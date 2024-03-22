
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

}
