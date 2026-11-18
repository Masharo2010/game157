import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

public class cupboard extends JPanel {

    private static final int SCREEN_W = 1280;
    private static final int SCREEN_H = 904;
    private static final int COPIES_PER_IMAGE = 3;
    private static final int TARGET_SIZE = 120;


    private static final int SPAWN_TOP    = SCREEN_H * 3 / 4;
    private static final int SPAWN_BOTTOM = SCREEN_H;
    private static final int SPAWN_LEFT   = 0;
    private static final int SPAWN_RIGHT  = SCREEN_W;


    private static final int    BUTTON_X      = 20;
    private static final int    BUTTON_Y      = 20;
    private static final int    BUTTON_WIDTH  = 180;
    private static final int    BUTTON_HEIGHT = 40;
    private static final String BUTTON_TEXT   = "выйти →";


    private BufferedImage background;
    private final List<DraggableImage> items = new ArrayList<>();

    private static class DraggableImage {
        BufferedImage image;
        int x, y;
        Point dragOffset = null;

        DraggableImage(BufferedImage image, int x, int y) {
            this.image = image;
            this.x = x;
            this.y = y;
        }

        Rectangle bounds() {
            return new Rectangle(x, y, image.getWidth(), image.getHeight());
        }
    }

    public cupboard() {
        setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));
        setBackground(Color.WHITE);
        setLayout(null);


        try {
            background = ImageIO.read(new File("src/picture/cupboard.jpeg"));
        } catch (IOException e) {
            background = null;
        }


        List<BufferedImage> images = new ArrayList<>();

        try {
            BufferedImage img1 = ImageIO.read(new File("src/picture/cupt.png"));
            if (img1 != null) { images.add(scaleImage(img1, TARGET_SIZE)); System.out.println("image1.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/cupt.png " + e.getMessage()); }

        try {
            BufferedImage img2 = ImageIO.read(new File("src/picture/Cupt2.png"));
            if (img2 != null) { images.add(scaleImage(img2, TARGET_SIZE)); System.out.println("image2.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/Cupt2.png " + e.getMessage()); }

        try {
            BufferedImage img3 = ImageIO.read(new File("src/picture/Cupt3.png"));
            if (img3 != null) { images.add(scaleImage(img3, TARGET_SIZE)); System.out.println("image3.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/Cupt3.png " + e.getMessage()); }

        try {
            BufferedImage img4 = ImageIO.read(new File("src/picture/Cupt4.png"));
            if (img4 != null) { images.add(scaleImage(img4, TARGET_SIZE)); System.out.println("image4.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/Cupt4.png" + e.getMessage()); }

        try {
            BufferedImage img5 = ImageIO.read(new File("src/picture/Cupt5.png"));
            if (img5 != null) { images.add(scaleImage(img5, TARGET_SIZE)); System.out.println("image5.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/Cupt5.png" + e.getMessage()); }

        try {
            BufferedImage img6 = ImageIO.read(new File("src/picture/Cupt6.png"));
            if (img6 != null) { images.add(scaleImage(img6, TARGET_SIZE)); System.out.println("image6.png OK"); }
        } catch (IOException e) { System.out.println("src/picture/Cupt6.png" + e.getMessage()); }

        if (images.isEmpty()) {
            System.out.println("Нет ни одной картинки — положите image1.png ... image6.png в корень проекта");
        } else {

            Random random = new Random();
            for (BufferedImage img : images) {
                for (int copy = 0; copy < COPIES_PER_IMAGE; copy++) {
                    int maxX = Math.max(SPAWN_LEFT, SPAWN_RIGHT - img.getWidth());
                    int maxY = Math.max(SPAWN_TOP,  SPAWN_BOTTOM - img.getHeight());
                    int x = SPAWN_LEFT + random.nextInt(Math.max(1, maxX - SPAWN_LEFT));
                    int y = SPAWN_TOP  + random.nextInt(Math.max(1, maxY - SPAWN_TOP));
                    items.add(new DraggableImage(img, x, y));
                }
            }
        }

        JButton openButton = new JButton(BUTTON_TEXT);
        openButton.setBounds(BUTTON_X, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        openButton.setFont(new Font("Arial", Font.BOLD, 14));
        openButton.setFocusPainted(false);
        openButton.setBackground(new Color(220, 240, 255));
        openButton.setToolTipText("Открыть другое окно (класс test2)");
        openButton.addActionListener(e -> {
            new test2();
        });
        add(openButton);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = items.size() - 1; i >= 0; i--) {
                    DraggableImage item = items.get(i);
                    if (item.bounds().contains(e.getPoint())) {
                        item.dragOffset = new Point(
                                e.getX() - item.x,
                                e.getY() - item.y
                        );
                        items.remove(i);
                        items.add(item);
                        repaint();
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (DraggableImage item : items) item.dragOffset = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                for (DraggableImage item : items) {
                    if (item.dragOffset != null) {
                        item.x = e.getX() - item.dragOffset.x;
                        item.y = e.getY() - item.dragOffset.y;
                        repaint();
                        break;
                    }
                }
            }
        });
    }

    private BufferedImage scaleImage(BufferedImage src, int maxSize) {
        int w = src.getWidth();
        int h = src.getHeight();
        if (w <= maxSize && h <= maxSize) return src;

        double scale = Math.min((double) maxSize / w, (double) maxSize / h);
        int newW = Math.max(1, (int) (w * scale));
        int newH = Math.max(1, (int) (h * scale));

        BufferedImage scaled = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = scaled.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(src, 0, 0, newW, newH, null);
        g2.dispose();
        return scaled;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(new GradientPaint(
                    0, 0, new Color(135, 206, 250),
                    0, getHeight(), new Color(25, 25, 112)
            ));
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        // (необязательно) видимая граница зоны появления
        g.setColor(new Color(255, 255, 255, 60));
        g.drawLine(0, SPAWN_TOP, getWidth(), SPAWN_TOP);

        for (DraggableImage item : items) {
            g.drawImage(item.image, item.x, item.y, null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new cupboard());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}