package Game;

import java.awt.Graphics;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Rock {

    public static int xRock1 = 600, yRock1 = 700;
    public static int xRock2 = 700, yRock2 = 100;
    public static int xRock3 = -20, yRock3 = 600;
    public static int xRock4 = 300, yRock4 = -20;

    public static int points = 0;
    public Game j;
    public static int level = 1;
    int increment = 2;

    Area r1, r2, r3, r4, rockArea;

    int initX = 0;
    int initY = 0;
    int endX = 700;
    int endY = 700;

    public Rock(Game j2) {
        this.j = j2;
    }

    public void paint(Graphics g) {
        ImageIcon rock = new ImageIcon(getClass().getResource("../Images/rock.png"));

        if (level >= 1) {
            g.drawImage(rock.getImage(), xRock1, yRock1, 48, 48, null);
        }
        if (level >= 2) {
            g.drawImage(rock.getImage(), xRock2, yRock2, 48, 48, null);
        }
        if (level >= 3) {
            g.drawImage(rock.getImage(), xRock3, yRock3, 48, 48, null);
        }
        if (level >= 4) {
            g.drawImage(rock.getImage(), xRock4, yRock4, 48, 48, null);
        }
    }

    public boolean choke() {
        Area areaSprite = new Area(j.insect.getBoundsInsect());
        areaSprite.intersect(getBoundsRock());
        return !areaSprite.isEmpty();
    }

    public void move() {
        if (choke()) {
            Game.hasCollided = true;
        }

        if (j.insect.theEnd()) {
            level++;
            Insect.x = 10;
            Insect.y = 10;
        }

        if (level >= 1) {
            if (yRock1 == -20) {
                yRock1 = 700;
                xRock1 = (int) (Math.random() * (endX + initX) + initX);
                points++;
            } else {
                yRock1 = yRock1 - increment;
            }
        }

        if (level >= 2) {
            if (xRock2 == -20) {
                xRock2 = 700;
                yRock2 = (int) (Math.random() * (endY + initY) + initY);
                points++;
            } else {
                xRock2 = xRock2 - increment;
            }
        }

        if (level >= 3) {
            if (xRock3 == 700) {
                xRock3 = -20;
                yRock3 = (int) (Math.random() * (endY + initY) + initY);
                points++;
            } else {
                xRock3 = xRock3 + increment;
            }
        }

        if (level >= 4) {
            if (xRock4 == 700) {
                yRock4 = -20;
                xRock4 = (int) (Math.random() * (endX + initX) + initX);
                points++;
            } else {
                yRock4 = yRock4 + increment;
            }
        }

    }

    public int getPoints() {
        return points;
    }

    public Area getBoundsRock() {
        Ellipse2D rock1, rock2, rock3, rock4;
        rock4 = new Ellipse2D.Double(xRock1, yRock1, 48, 48);
        r4 = new Area(rock4);
        rockArea = r4;

        if (level >= 1) {
            rock1 = new Ellipse2D.Double(xRock1, yRock1, 48, 48);
            r1 = new Area(rock1);
        }
        if (level >= 2) {
            rock2 = new Ellipse2D.Double(xRock2, yRock2, 48, 48);
            r2 = new Area(rock2);
            rockArea.add(r2);
        }
        if (level >= 3) {
            rock3 = new Ellipse2D.Double(xRock3, yRock3, 48, 48);
            r3 = new Area(rock3);
            rockArea.add(r3);
        }
        if (level >= 4) {
            rock4 = new Ellipse2D.Double(xRock4, yRock4, 48, 48);
            r4 = new Area(rock4);
            rockArea.add(r4);
        }
        return rockArea;
    }

}
