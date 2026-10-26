/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class game_fox extends JFrame {
    public BufferedImage bg, fox;
    public int x=50;
    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {                x++;                repaint();            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {                x--;                repaint();            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    game_fox()
    {
        try {
            bg = ImageIO.read(new File("src/img/fon.jpg"));
            fox = ImageIO.read(new File("src/img/fox.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(900,450);
        setVisible(true);
        addKeyListener(kl);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(bg,0,0,this);
        g.drawImage(fox,x,300,this);
    }

    public static void main(String[] args)
    {
        new game_fox();
    }




}



/*mport javafx.scene.input.KeyCode;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Frame {
    public BufferedImage spider, spiderman;
    public int x=50;
    public spider[] spiders = new spider[10];
    public KeyListener kl=new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {


    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                x++;
                repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                x--;
                repaint();
            }

        }
        /*if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y = y + 1;
            System.out.println("y");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y = y - 1;
            System.out.println("y");
            repaint();
        }*/

    /*}

    @Override
    public void keyReleased(KeyEvent e) {

    }
};
    Main()
    {
        try {
            spiderman= ImageIO.read(new File("src/picture/человек паук.png"));
            spider= ImageIO.read(new File("src/picture/spider.jpg"));

        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }



        /*setTitle("first drawing");*/
        /*setSize( 900,450);
        setVisible(true);
        addKeyListener(kl);
        /*for(int i=0; i<spiders.length; i++){
            spiders[i]= new spider();*/
 /*       }
    }

      public void paint(Graphics g)
      {

          super.paint(g);
          g.drawImage(spiderman,0,0,this);
          g.drawImage(spider, x,300,this);

          /*for(int i=0; i<spiders.length; i++)
          {
              g.drawImage(spiders[i].image, spiders[i].x,spiders[i].y, this);
          }
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

  /*  }
    public static void main(String[] args) {
        new Main(); 
    }
}


    /*public static void main(String[] args) {


            System.out.println("");
        }
    }
*/