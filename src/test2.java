import javax.swing.*;
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

    }
}
