import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {

            Board board = new Board();
            Game gamePanel = new Game(board);
            gamePanel.displayGameWindow();
    }
}
