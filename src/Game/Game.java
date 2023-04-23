package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

    static boolean hasCollided;

    Rock rock = new Rock(this);
    Insect insect = new Insect();

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                insect.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ImageIcon spiderweb = new ImageIcon(getClass().getResource("../Images/spiderweb.png"));
        g.drawImage(spiderweb.getImage(), 0, 0, getWidth(), getHeight(), this);

        Font score = new Font("Arial", Font.BOLD, 25);
        g.setFont(score);
        g.setColor(Color.blue);
        g.drawString("SCORE: " + rock.getPoints(), 520, 50);

        insect.paint(g);
        rock.paint(g);
        rock.move();
        g.dispose();

    }

    public static void main(String[] args) {
        JFrame myWindow = new JFrame("Running Spider");
        Game game = new Game();
        myWindow.add(game);
        myWindow.setSize(700, 700);
        myWindow.setVisible(true);
        myWindow.setResizable(false);
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (hasCollided | Rock.level == 5) {
                if (Rock.level == 5) {
                    JOptionPane.showMessageDialog(null, " You've Won Congratulations!!!");
                }
                int restartGame = JOptionPane.showConfirmDialog(null, "You Lose, " + "Do You Want To Play Again", "You Lose", JOptionPane.YES_NO_OPTION);
                if (restartGame == 0) {
                    resetSettings();
                } else if (restartGame == 1) {
                    System.exit(0);
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            game.repaint();
        }

    }

    public static void resetSettings() {
        Rock.xRock1 = 600;
        Rock.yRock1 = 700;
        Rock.xRock1 = 700;
        Rock.yRock1 = 100;
        Rock.xRock1 = -20;
        Rock.yRock1 = 600;
        Rock.xRock1 = 300;
        Rock.yRock1 = -20;
        Insect.x = 10;
        Insect.y = 10;
        Rock.level = 1;
        hasCollided = false;
        Rock.points = 0;

    }
}
