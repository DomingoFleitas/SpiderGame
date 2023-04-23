package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Insect {

    public static int x = 10, y = 10;

    public void paint(Graphics g) {
        ImageIcon hole = new ImageIcon(getClass().getResource("../Images/hole.png"));
        g.drawImage(hole.getImage(), 500, 500, 150, 150, null);

        ImageIcon spider = new ImageIcon(getClass().getResource("../Images/spider.png"));
        g.drawImage(spider.getImage(), x, y, 100, 100, null);

    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 37) {
            if (x > 0) {
                x = x - 20;
            }
        }

        if (e.getKeyCode() == 39) {
            if (x < 580) {
                x = x + 20;
            }
        }

        if (e.getKeyCode() == 38) {
            if (y > 0) {
                y = y - 20;
            }
        }

        if (e.getKeyCode() == 40) {
            if (y < 580) {
                y = y + 20;
            }
        }
    }

    public Ellipse2D getBoundsInsect() {
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }

    public boolean theEnd() {
        Rectangle rectangle = new Rectangle(520, 520, 110, 110);
        Area rectangleArea = new Area(rectangle);
        return rectangleArea.contains(getBoundsInsect().getBounds());
    }
}
