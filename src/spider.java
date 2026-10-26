/*import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class spider {
    public BufferedImage image;
    public int x,y;

    spider()
    {
        try {
            image = ImageIO.read(new File("src/picture/spider.jpg"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        x=new Random().nextInt(800);
        y=new Random().nextInt(300);
        }
        void move() {
            y += 5;
            if (y < 450) {
                y = -100;
                x = new Random().nextInt(800);
            }
        }
        public boolean intersect(character c)
        {
            boolean answer = false;
            return answer;
        }

}*/

