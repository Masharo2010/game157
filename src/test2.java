import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class test2 extends JFrame {
    public BufferedImage bg, button_start, button_setting, button_exit;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getPoint().x > 0 && e.getPoint().x < 50 && e.getPoint().y > 50 && e.getPoint().y < 100) {
                new menu();
                System.out.println("exit");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    };

    test2() {
        try {
            bg = ImageIO.read(new File("src/picture/фон.png"));
            button_setting = ImageIO.read(new File("src/picture/настройки.png"));
            button_exit = ImageIO.read(new File("src/picture/домой.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(1280, 904); 
        setVisible(true);
        setTitle("game");
        addMouseListener(ml);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg, 0, 0, this);
        g.drawImage(button_setting, 0, 50, this);
        g.drawImage(button_exit, 0, 100, this);
    }

    public static void main(String[] args) {
        new test2();
    }
}


/*import javax.swing.*;
import java.awt.*;

public class test2 extends JFrame {
    test2()
    {
        setVisible(true);
        setSize(800, 600);
        setTitle("Заголовок окна");
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.drawRect(100,200,100,100);
        g.drawLine(150,100,200,200);
        g.drawLine(150,100,100,200);
    }
    public static void main(String[] args)
    {
        new test2();
      /* homehelper spidermen = new homehelper();
       System.out.println(spidermen.x+" "+spidermen.x+" "+spidermen.isVisible);
        spidermen.move (0,15);
        System.out.println(spidermen.x+" "+spidermen.x+" "+spidermen.isVisible);*/

    /*}
}*/
