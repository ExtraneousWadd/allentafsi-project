import javax.swing.JPanel;
import java.awt.*;

public class Game extends JPanel{
    public static final int width = 900;
    public static final int height = 900;

    public Game(){
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    private void update(){

    }
    public void paint(Graphics x){
       x.setColor(Color.BLACK);
       x.fillRect(0,0,900,50);
       x.fillRect(0,850,900,50);
       x.fillRect(0,0,50,900);
       x.fillRect(850,0,50,900);
       int c = 0;
       for(int row = 0; row < 8; row++){
           for(int col = 0; col < 8; col++){
               if(c == 0){
                   x.setColor(Color.WHITE);
                   c = 1;
               } else {
                   x.setColor(new Color(86, 188, 71));
                   c = 0;
               }
               x.fillRect(row * 100 + 50, col * 100 + 50, 100, 100);
           }
           if(c == 0){
               c = 1;
           } else {
               c = 0;
           }
       }
    }

}
