import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
 
public class menu extends JFrame {
    public BufferedImage bg, button_start, button_setting, button_exit, bg2;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getPoint().x > 450 && e.getPoint().x < 850 && e.getPoint().y > 500 && e.getPoint().y < 800) {
                dispose();
                new test2();
                System.out.println("start");
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

    menu() {
        try {
            bg = ImageIO.read(new File("src/picture/фон.png"));
            button_start = ImageIO.read(new File("src/picture/начать.png"));
            button_setting = ImageIO.read(new File("src/picture/настройки.png"));
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
        g.drawImage(button_start, 480, 500, this);
        g.drawImage(button_setting, 0, 50, this);
        g.drawImage(button_exit, 0, 100, this);
    }

    public static void main(String[] args) {
        new menu();
    }
}
