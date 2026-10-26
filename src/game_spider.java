/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class game_spider extends JFrame {
    public BufferedImage spiderman, bg;
    public int x=50;
    public ArrayList<spider> spiders = new ArrayList<spider>();
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
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if (spiders.size()>0)
                {
                    spiders.remove(new Random().nextInt(spiders.size()));
                    repaint();
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<spiders.size();i++ )
                spiders.get(i).move();
            repaint();
        }
    };
    Timer time = new Timer(100,al);

    game_spider()
    {
        try {
            bg = ImageIO.read(new File("src/picture/фон.png"));
            spiderman = ImageIO.read(new File("src/picture/человек паук.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(900,450);
        setVisible(true);
        addKeyListener(kl);
        for (int i=0; i< 5;i++)
        {
            spiders.add(new spider());
        }
        time.start();
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(bg,0,0,this);
        g.drawImage(spiderman,x,300,this);
        for (int i=0; i< spiders.size(); i++)
        {
            g.drawImage(spiders.get(i).image, spiders.get(i).x, spiders.get(i).y, this);
        }
    }

    public static void main(String[] args)
    {
        new game_spider();
    }




}*/

