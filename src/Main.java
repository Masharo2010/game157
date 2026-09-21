import javafx.scene.input.KeyCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Frame {
    public int x=0, y=0;
    public KeyListener al=new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            x=x-1;
            System.out.println("x");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            x=x+1;
            System.out.println("x");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y = y + 1;
            System.out.println("y");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y = y - 1;
            System.out.println("y");
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
};
    public BufferedImage im;
    public Main()
    {
        try {
            im= ImageIO.read(new File("C:/Users/romanovamk.28/IdeaProjects/game157/src/человек паук.png")); }

        catch (IOException e) {
            throw new RuntimeException(e);
        }



        setTitle("first drawing");
        setSize( 800 ,640);
        setVisible(true);
        addKeyListener(al);
    }

      public void paint(Graphics g)
      {

          super.paint(g);
          Graphics2D isa = (Graphics2D) g;
          g.drawImage(im, x,y,this);
          /*
          g.setColor(Color.YELLOW);
          g.fillOval(100,100,50,50);
          g.setColor(Color.YELLOW);
          g.drawLine(100,100,20, 20);
          g.drawLine(150,150,300,300);
          g.drawLine(160,120,300,100);
          g.drawLine(140,100,150,20);
          g.drawLine(130,150,200,400);
          g.drawLine(100,150,20,400);
          g.drawLine(100,125,20,100);
          g.setColor(Color.RED);
          */

             // g.clearRect(0,0,800,640);
             // g.fillOval(x , y, 50, 50);

    }
    public static void main(String[] args) {
        new Main(); 
    }
}


    /*public static void main(String[] args) {


            System.out.println("");
        }
    }
*/