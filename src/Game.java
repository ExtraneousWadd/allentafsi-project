import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JPanel {
    private Board board;
    private Image[][] pieceImages;
    private Image[][] whitePieceImages;
    private Image[][] blackPieceImages;
    private JTextField moveInputField;
    private JButton submitMoveButton;

    public static final int width = 1300;
    public static final int height = 900;

    public Game(Board board) {
        this.board = board;
        setPreferredSize(new Dimension(1300, 900)); // Setting the total size of the panel
        setBackground(Color.BLACK);
        setLayout(null); // Using a null layout for absolute positioning
        loadPieceImages();
        initializeUserInputComponents();
    }
    public void displayGameWindow() {
        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(this); // Add the Game panel to the window
        window.pack();
        window.setLocationRelativeTo(null); // Center the window
        window.setVisible(true);
    }
    private void initializeUserInputComponents() {
        moveInputField = new JTextField(); // Creates the text field
        submitMoveButton = new JButton("Submit Move"); // Creates the button

        // Positioning the text field
        moveInputField.setBounds(1000, 400, 180, 30); // Positioned to the right of the chessboard
        add(moveInputField); // Adds the text field to the panel

        // Positioning the submit button below the text field
        submitMoveButton.setBounds(1000, 450, 180, 30); // Adjusted to align below the text field
        add(submitMoveButton); // Adds the button to the panel

        // Add action listener to the submit button
        submitMoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String move = moveInputField.getText();
                // Logic to process the move
                moveInputField.setText(""); // Clear the input field after submitting
                repaint(); // Repaint the board
            }
        });
    }


    private void loadPieceImages() {
        pieceImages = new Image[8][8];
        whitePieceImages = new Image[8][8];
        blackPieceImages = new Image[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null) {
                    String colorPrefix = piece.getColor().equals("white") ? "white_" : "black_";
                    String pieceType = piece.getClass().getSimpleName().toLowerCase();
                    String imagePath = "src/" + colorPrefix + pieceType + ".png";
                    try {
                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image image = imageIcon.getImage();
                        pieceImages[row][col] = image;
                        if (piece.getColor().equals("white")) {
                            whitePieceImages[row][col] = image;
                        } else {
                            blackPieceImages[row][col] = image;
                        }
                    } catch (Exception e) {
                        System.err.println("Error loading image: " + e.getMessage());
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the chessboard
        drawChessboard(g);

        // Draw the pieces
        drawWhitePieces(g);
        drawBlackPieces(g);

        // Draw coordinates
        drawCoordinates(g);
    }

    private void drawChessboard(Graphics g) {
        int squareSize = 120;
        int boardSize = squareSize * 8;

        int c = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (c == 0) {
                    g.setColor(Color.WHITE);
                    c = 1;
                } else {
                    g.setColor(new Color(86, 188, 71));
                    c = 0;
                }
                g.fillRect(row * 100 + 50, col * 100 + 50, 100, 100);
            }
            if (c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }

    private void drawWhitePieces(Graphics g) {
        if (whitePieceImages != null) {
            drawPieces(g, whitePieceImages);
        }
    }

    private void drawBlackPieces(Graphics g) {
        if (blackPieceImages != null) {
            drawPieces(g, blackPieceImages);
        }
    }

    private void drawPieces(Graphics g, Image[][] pieceImages) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Image image = pieceImages[row][col];
                if (image != null) {
                    g.drawImage(image, col * 100 + 50, row * 100 + 50, 100, 100, this);
                }
            }
        }
    }

    private void drawCoordinates(Graphics g) {
        int ycoord = 800;
        int xcoord = 100;
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        for (int i = 1; i < 9; i++) {
            g.drawString(Integer.toString(i), 25, ycoord);
            ycoord -= 100;
        }
        ycoord = 800;
        for (int i = 1; i < 9; i++) {
            g.drawString(Integer.toString(i), 860, ycoord);
            ycoord -= 100;
        }

        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");

        for (int i = 0; i < letters.size(); i++) {
            g.drawString(letters.get(i), xcoord, 25);
            xcoord += 100;
        }

        xcoord = 100;
        for (int i = 0; i < letters.size(); i++) {
            g.drawString(letters.get(i), xcoord, 875);
            xcoord += 100;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}

