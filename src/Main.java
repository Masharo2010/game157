import java.awt.*;

public class Main extends Frame {
    public Main()
    {
        setTitle("first drawing");
        setSize( 800 ,640);
        setVisible(true);
    }

      public void paint(Graphics g)
      {
          super.paint(g);
          Graphics2D isa = (Graphics2D) g;
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