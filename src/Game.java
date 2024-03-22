import javax.swing.JPanel;
import java.awt.*;

public class Game extends JPanel{
    public static final int width = 1100;
    public static final int height = 800;

    public Game(){
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    private void update(){

    }
    public void paint(Graphics x){
        super.paintComponent(x);
    }

}
