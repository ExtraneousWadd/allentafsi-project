import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        Game panel = new Game(board);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        /*

        Board board = new Board();
        board.printBoard();

         */
    }
}
