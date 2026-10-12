

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class menu extends JFrame {
    public BufferedImage bg, button_start, button_setting, button_exit;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    menu() {
        try {
            bg = ImageIO.read(new File("src/knopka.png"));
            button_start = ImageIO.read(new File("src/человек паук.png"));
            button_setting = ImageIO.read(new File("src/knopka.png"));
            button_exit = ImageIO.read(new File("src/человек паук.png"));
       } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("first drawing");
        setSize(800, 640);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg, 108, 100, this);
        g.drawImage(button_start, 108, 200, this);
        g.drawImage(button_setting, 200, 300, this);
        g.drawImage(button_exit, 400, 400, this);

    }

    public static void main(String[] args)
    {
        menu name = new menu();
    }
}