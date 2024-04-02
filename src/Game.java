import javax.swing.*;
import java.awt.*;
import java.util.*;

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
       int ycoord = 800;
       int xcoord = 100;
       x.setFont(new Font("Arial", Font.PLAIN, 18));
       for (int i = 1; i < 9; i++){
           x.drawString(Integer.toString(i), 25, ycoord);
           ycoord -= 100;
       }
       ycoord = 800;
       for (int i = 1; i < 9; i++){
           x.drawString(Integer.toString(i), 860, ycoord);
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

       for (int i = 0; i < letters.size(); i++){
           x.drawString(letters.get(i), xcoord, 25);
           xcoord += 100;
       }

       xcoord = 100;
       for (int i = 0; i < letters.size(); i++){
           x.drawString(letters.get(i), xcoord, 875);
           xcoord += 100;
       }


    }

}
