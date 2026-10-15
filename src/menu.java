

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class menu extends JFrame {
    public BufferedImage bg, button_start, button_setting, button_exit;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getPoint().x > 40 && e.getPoint().x < 70 && e.getPoint().y > 100 && e.getPoint().y < 216) {
                new test2();
                System.out.println("start");
            }
            if (e.getPoint().x > 30 && e.getPoint().x < 100 && e.getPoint().y > 50 && e.getPoint().y < 216) {
                new test2();
                System.out.println("exit");
                System.exit(0);
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
            bg = ImageIO.read(new File("H:/жесть/проект/gameproject/фон.png"));
            button_start = ImageIO.read(new File("H:/жесть/проект/gameproject/начать.png"));
            button_setting = ImageIO.read(new File("H:/жесть/проект/gameproject/настройки.png"));
            button_exit = ImageIO.read(new File("H:/жесть/проект/gameproject/домой.png"));
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
        g.drawImage(button_start, 40, 70, this);
        g.drawImage(button_setting, 30, 10, this);
        g.drawImage(button_exit, 30, 100, this);
    }

    public static void main(String[] args) {
        new menu();
    }
}
